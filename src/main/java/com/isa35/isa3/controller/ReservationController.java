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

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponse> claimPromotion(@PathVariable String id, HttpServletRequest request) {
        User user = userService.findByUsername(tokenUtils.getUsernameFromToken(tokenUtils.getToken(request)));
        Reservation promotion = reservationService.findById(Long.parseLong(id));
        if (!promotion.isPromotion() || promotion.isExpired())
            return new ResponseEntity<>(HttpStatus.GONE);
        Reservation reservation = reservationService.claim(user, promotion);
        return new ResponseEntity<>(new ReservationResponse(reservation), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void cancelReservation() {

    }
}
