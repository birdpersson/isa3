package com.isa35.isa3.controller;

import com.isa35.isa3.dto.*;
import com.isa35.isa3.model.Cabin;
import com.isa35.isa3.model.Reservation;
import com.isa35.isa3.model.Review;
import com.isa35.isa3.model.User;
import com.isa35.isa3.security.TokenUtils;
import com.isa35.isa3.service.CabinService;
import com.isa35.isa3.service.ReservationService;
import com.isa35.isa3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.threeten.extra.Interval;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cabin")
public class CabinController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private CabinService cabinService;

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/search")
    public ResponseEntity<List<Cabin>> searchCabins(@RequestBody CabinQuery searchQuery) {
        return new ResponseEntity<>(cabinService.findByAvailability(searchQuery), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CabinResponse>> getCabins() {
        List<Cabin> cabins = cabinService.findAll();
        List<CabinResponse> list = new ArrayList<>();
        for (Cabin c : cabins) {
            list.add(new CabinResponse(c));
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CabinResponse> createCabin(@RequestBody CabinRequest dto, HttpServletRequest request) {
        User user = userService.findByUsername(tokenUtils.getUsernameFromToken(tokenUtils.getToken(request)));
        return new ResponseEntity<>(new CabinResponse(cabinService.create(user, dto)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CabinResponse> getCabin(@PathVariable String id) {
        return new ResponseEntity<>(new CabinResponse(cabinService.findById(Long.parseLong(id))), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cabin> editCabin(@RequestBody CabinRequest cabinDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Cabin> uploadImages(@PathVariable String id, @RequestParam("image") MultipartFile[] files) {
        return new ResponseEntity<>(cabinService.upload(files, Long.parseLong(id)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cabin> deleteCabin(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/{id}/reservation")
    public ResponseEntity<ReservationResponse> createReservation(
            @PathVariable String id, @RequestBody ReservationRequest dto, HttpServletRequest request) {
        User user = userService.findByUsername(tokenUtils.getUsernameFromToken(tokenUtils.getToken(request)));
        Cabin cabin = cabinService.findById(Long.parseLong(id));

        Interval interval = Interval.of(dto.getStart(), Duration.ofDays(dto.getDays()));

        System.out.println("Available:" + cabin.getAvailability());
        System.out.println("Reserving:" + interval);

        if (!cabin.getAvailability().encloses(interval))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        for (Reservation reservation : cabin.getReservations()) {
            System.out.println("Intervals:" + reservation.getInterval());
            if (interval.overlaps(reservation.getInterval()))
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Reservation reservation = reservationService.create(user, cabin, dto);
        return new ResponseEntity<>(new ReservationResponse(reservation), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/promotion")
    public ResponseEntity<Reservation> createPromotion(@PathVariable String id, @RequestBody ReservationRequest dto) {
        Cabin cabin = cabinService.findById(Long.parseLong(id));
        return new ResponseEntity<>(reservationService.promote(cabin, dto), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/review")
    public ResponseEntity<Review> createReview(@PathVariable String id, @RequestBody ReviewDTO dto, HttpServletRequest request) {
        Cabin cabin = cabinService.findById(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
