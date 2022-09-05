package com.isa35.isa3.dto;

import com.isa35.isa3.model.Reservation;

import java.time.Instant;
import java.util.Collection;

public class PromotionResponse {
    private final Long id;
    private final Long cabinId;
    private final String interval;
    private final Instant expiry;
    private final Integer people;
    private final Integer price;
    private final String type;
    private final Collection<String> amenities;

    public PromotionResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.cabinId = reservation.getCabin().getId();
        this.interval = reservation.getInterval().toString();
        this.expiry = reservation.getExpiry();
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

    public String getInterval() {
        return interval;
    }

    public Instant getExpiry() {
        return expiry;
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
