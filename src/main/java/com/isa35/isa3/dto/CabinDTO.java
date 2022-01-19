package com.isa35.isa3.dto;

public class CabinDTO {

    private String name;
    private String address;
    private String description;
    private Long availableFrom;
    private Long availableTo;
    private String priceList;
    private String rules;
    private int rooms;
    private int beds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Long availableFrom) {
        this.availableFrom = availableFrom;
    }

    public Long getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(Long availableTo) {
        this.availableTo = availableTo;
    }

    public String getPriceList() {
        return priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }
}
