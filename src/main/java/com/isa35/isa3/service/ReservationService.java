package com.isa35.isa3.service;

import com.isa35.isa3.dto.ReservationRequest;
import com.isa35.isa3.model.Cabin;
import com.isa35.isa3.model.Reservation;
import com.isa35.isa3.model.User;
import com.isa35.isa3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.extra.Interval;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository repository;

    public Reservation findById(Long id) {
        return repository.findById(id).orElseGet(null);
    }

    public Reservation create(User guest, Cabin cabin, ReservationRequest dto) {
        Reservation r = new Reservation();
        r.setType(Reservation.Type.RESERVATION);
        r.setInterval(Interval.of(dto.getStart(), Duration.ofDays(dto.getDays())));
        r.setPrice(dto.getPrice());
        r.setGuest(guest);
        r.setCabin(cabin);
        guest.addReservation(r);
        cabin.addReservation(r);
        return repository.save(r);
    }

    public Reservation promote(Cabin cabin, ReservationRequest dto) {
        Reservation r = new Reservation();
        Interval interval = Interval.of(dto.getStart(), Duration.ofDays(dto.getDays()));

        for (Reservation reservation : cabin.getReservations()) {
            if (interval.overlaps(reservation.getInterval())) throw new DateTimeException("Reservation Overlap");
        }

        if (cabin.getAvailability().encloses(interval)) r.setInterval(interval);
        else throw new DateTimeException("Reservation Exceeds Availability Range");

        r.setType(Reservation.Type.PROMOTION);
        r.setExpiry(dto.getExpiry());
        r.setPrice(dto.getPrice());
        r.setCabin(cabin);

        return repository.save(r);
    }

    public Reservation claim(User user, Reservation reservation) {

        if (Instant.now().isBefore(reservation.getExpiry())) {
            reservation.setType(Reservation.Type.RESERVATION);
            reservation.setGuest(user);
        }

        return repository.save(reservation);
    }

}
