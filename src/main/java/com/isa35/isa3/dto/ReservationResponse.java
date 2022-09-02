package com.isa35.isa3.dto;

import com.isa35.isa3.model.Reservation;

import java.util.Collection;

public class ReservationResponse {
    private final Long id;
    private final Long cabinId;
    private final Long guestId;
    private final String username;
    private final String interval;
    private final Integer people;
    private final Integer price;
    private final String type;
    private final Collection<String> amenities;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.cabinId = reservation.getCabin().getId();
        this.guestId = reservation.getGuest().getId();
        this.username = reservation.getGuest().getUsername();
        this.interval = reservation.getInterval().toString();
        this.people = reservation.getPeople();
        this.price = reservation.getPrice();
        this.type = reservation.getType().toString();
        this.amenities = reservation.getAmenities();
    }

    public Long getId() {
        return id;
    }

    public Long getCabinId() {
        return cabinId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public String getUsername() {
        return username;
    }

    public String getInterval() {
        return interval;
    }

    public Integer getPeople() {
        return people;
    }

    public Integer getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Collection<String> getAmenities() {
        return amenities;
    }
}
