package com.isa35.isa3.controller;

import com.isa35.isa3.dto.ReservationResponse;
import com.isa35.isa3.model.Reservation;
import com.isa35.isa3.model.User;
import com.isa35.isa3.security.TokenUtils;
import com.isa35.isa3.service.ReservationService;
import com.isa35.isa3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/")
    public ResponseEntity<List<ReservationResponse>> getReservations(HttpServletRequest request) {
        User user = userService.findByUsername(tokenUtils.getUsernameFromToken(tokenUtils.getToken(request)));
        Collection<Reservation> reservations = user.getReservations();
        List<ReservationResponse> list = new ArrayList<>();
        for (Reservation r : reservations) {
            list.add(new ReservationResponse(r));
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/{id}/claim")
    public ResponseEntity<ReservationResponse> claimPromotion(@PathVariable String id, HttpServletRequest request) {
        User user = userService.findByUsername(tokenUtils.getUsernameFromToken(tokenUtils.getToken(request)));
        Reservation promotion = reservationService.findById(Long.parseLong(id));
        if (promotion.isPromotion() && promotion.isExpired())
            return new ResponseEntity<>(HttpStatus.GONE);
        Reservation reservation = reservationService.claim(user, promotion);
        return new ResponseEntity<>(new ReservationResponse(reservation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<ReservationResponse> cancelReservation(@PathVariable String id, HttpServletRequest request) {
        String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
        Reservation reservation = reservationService.findById(Long.parseLong(id));
        if (!reservation.getGuest().getUsername().equals(username))
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        if (!reservation.isThreeDaysBeforeStart())
            return new ResponseEntity<>(HttpStatus.GONE);
        return new ResponseEntity<>(new ReservationResponse(reservationService.cancel(reservation)), HttpStatus.CREATED);
    }
}
