package com.isa35.isa3.dto;

import com.isa35.isa3.model.Amenity;

public class AmenityResponse {
    private final String name;
    private final Integer price;

    public AmenityResponse(Amenity amenity) {
        this.name = amenity.getName();
        this.price = amenity.getPrice();
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
