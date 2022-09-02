package com.isa35.isa3.dto;

import java.time.Instant;
import java.util.ArrayList;

public class ReservationRequest {
    private Instant start;
    private Long duration;
    private Integer price;
    private Integer people;
    private Instant expiry;
    private ArrayList<String> amenities;

    public Instant getStart() {
        return start;
    }

    public void setStart(Instant start) {
        this.start = start;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Instant getExpiry() {
        return expiry;
    }

    public void setExpiry(Instant expiry) {
        this.expiry = expiry;
    }

    public ArrayList<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(ArrayList<String> amenities) {
        this.amenities = amenities;
    }
}
