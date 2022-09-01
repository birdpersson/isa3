package com.isa35.isa3.dto;

import com.isa35.isa3.model.Reservation;

public class ReservationResponse {
    private final String interval;
    private final String username;
    private final Long guestId;
    private final Long cabinId;
    private final Integer price;
    private final Reservation.Type type;
    private final Long id;

    public ReservationResponse(Reservation r) {
        this.interval = r.getInterval().toString();
        this.username = r.getGuest().getUsername();
        this.guestId = r.getGuest().getId();
        this.cabinId = r.getCabin().getId();
        this.price = r.getPrice();
        this.type = r.getType();
        this.id = r.getId();
    }

    public String getInterval() {
        return interval;
    }

    public String getUsername() {
        return username;
    }

    public Long getGuestId() {
        return guestId;
    }

    public Long getCabinId() {
        return cabinId;
    }

    public Integer getPrice() {
        return price;
    }

    public Reservation.Type getType() {
        return type;
    }

    public Long getId() {
        return id;
    }
}
