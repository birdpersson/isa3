package com.isa35.isa3.dto;

import com.isa35.isa3.model.Review;

public class ReviewResponse {
    private final Long id;
    private final String status;
    private final Integer rating;
    private final String comment;
    private final String cabinId;
    private final String guestId;
    private final String cabinName;
    private final String username;

    public ReviewResponse(Review review) {
        this.id = review.getId();
        this.status = review.getStatus().toString();
        this.rating = review.getRating();
        this.comment = review.getComment();
        this.cabinId = review.getCabin().getId().toString();
        this.guestId = review.getGuest().getId().toString();
        this.cabinName = review.getCabin().getName();
        this.username = review.getGuest().getUsername();

    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getCabinId() {
        return cabinId;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getCabinName() {
        return cabinName;
    }

    public String getUsername() {
        return username;
    }
}
