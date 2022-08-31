package com.isa35.isa3.dto;

import com.isa35.isa3.model.Reservation;

public class ReservationResponse {
    String interval;
    String username;
    Long guestId;
    Long cabinId;
    Integer price;
    Reservation.Type type;
    Long id;

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

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Long getCabinId() {
        return cabinId;
    }

    public void setCabinId(Long cabinId) {
        this.cabinId = cabinId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Reservation.Type getType() {
        return type;
    }

    public void setType(Reservation.Type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReservationResponse{" +
                "interval='" + interval + '\'' +
                ", username='" + username + '\'' +
                ", guestId=" + guestId +
                ", cabinId=" + cabinId +
                ", price=" + price +
                ", type=" + type +
                ", id=" + id +
                '}';
    }
}
