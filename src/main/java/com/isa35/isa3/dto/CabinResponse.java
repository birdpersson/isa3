package com.isa35.isa3.dto;

import com.isa35.isa3.model.Cabin;

import java.time.Instant;

public class CabinResponse {
    private final Long id;
    private final String name;
    private final String address;
    private final String description;
    private final String availableFrom;
    private final String availableTo;
    private final Integer people;
    private final Integer price;
    private final Integer cost;
    private final String rules;

    public CabinResponse(Cabin cabin) {
        this.id = cabin.getId();
        this.name = cabin.getName();
        this.address = cabin.getAddress();
        this.description = cabin.getDescription();
        this.availableFrom = cabin.getOffsetStart().toString();
        this.availableTo = cabin.getOffsetEnd().toString();
        this.people = cabin.getPeople();
        this.price = cabin.getPrice();
        this.cost = cabin.getCost();
        this.rules = cabin.getRules();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getAvailableFrom() {
        return availableFrom;
    }

    public String getAvailableTo() {
        return availableTo;
    }

    public Integer getPeople() {
        return people;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCost() {
        return cost;
    }

    public String getRules() {
        return rules;
    }

}
