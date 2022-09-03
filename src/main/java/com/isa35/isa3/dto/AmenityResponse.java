package com.isa35.isa3.dto;

import com.isa35.isa3.model.Amenity;

public class AmenityResponse {
    private final Long id;
    private final String name;
    private final Integer price;

    public AmenityResponse(Amenity amenity) {
        this.id = amenity.getId();
        this.name = amenity.getName();
        this.price = amenity.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
