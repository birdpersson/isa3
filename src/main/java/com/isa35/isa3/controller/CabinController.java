package com.isa35.isa3.controller;

import com.isa35.isa3.dto.CabinDTO;
import com.isa35.isa3.dto.ReservationDTO;
import com.isa35.isa3.dto.ReviewDTO;
import com.isa35.isa3.dto.CabinQuery;
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

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity<List<Cabin>> getCabins() {
        return new ResponseEntity<>(cabinService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Cabin> createCabin(@RequestBody CabinDTO cabinDTO) {
        return new ResponseEntity<>(cabinService.create(cabinDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cabin> getCabin(@PathVariable String id) {
        return new ResponseEntity<>(cabinService.findById(Long.parseLong(id)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cabin> editCabin(@RequestBody CabinDTO cabinDTO) {
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
    public ResponseEntity<Reservation> createReservation(@PathVariable String id, @RequestBody ReservationDTO dto, HttpServletRequest request) {
        User user = userService.findByUsername(tokenUtils.getUsernameFromToken(tokenUtils.getToken(request)));
        Cabin cabin = cabinService.findById(Long.parseLong(id));

        return new ResponseEntity<>(reservationService.create(user, cabin, dto), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/promotion")
    public ResponseEntity<Reservation> createPromotion(@PathVariable String id, @RequestBody ReservationDTO dto) {
        Cabin cabin = cabinService.findById(Long.parseLong(id));
        return new ResponseEntity<>(reservationService.promote(cabin, dto), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/review")
    public ResponseEntity<Review> createReview(@PathVariable String id, @RequestBody ReviewDTO dto, HttpServletRequest request) {
        Cabin cabin = cabinService.findById(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
