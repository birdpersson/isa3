package com.isa35.isa3.dto;

import com.isa35.isa3.model.Review;

public class ReviewResponse {
    Long id;
    String status;
    Integer rating;
    String comment;
    String cabinId;
    String guestId;

    public ReviewResponse(Review review) {
        this.id = review.getId();
        this.status = review.getStatus().toString();
        this.rating = review.getRating();
        this.comment = review.getComment();
        this.cabinId = review.getCabin().getId().toString();
        this.guestId = review.getGuest().getId().toString();
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
}
