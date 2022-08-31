package com.isa35.isa3.model;

import org.threeten.extra.Interval;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Cabin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String description;

    @Column
    private Instant availabilityStart;

    @Column
    private Instant availabilityEnd;

    @Column
    private String priceList;

    @Column
    private String rules;

    @Column
    private int rooms;

    @Column
    private int beds;

    @ManyToOne
    private User host;

    @OneToMany
    private Collection<Reservation> reservations = new HashSet<>();

    @OneToMany
    private Collection<Amenity> amenities;

    @OneToMany
    private Collection<Review> reviews;

    @ElementCollection
    private Collection<String> images;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public Collection<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(Collection<Amenity> amenities) {
        this.amenities = amenities;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public Collection<String> getImages() {
        return images;
    }

    public void setImages(Collection<String> images) {
        this.images = images;
    }

    public Instant getAvailabilityStart() {
        return availabilityStart;
    }

    public void setAvailabilityStart(Instant availabilityStart) {
        this.availabilityStart = availabilityStart;
    }

    public Instant getAvailabilityEnd() {
        return availabilityEnd;
    }

    public void setAvailabilityEnd(Instant availabilityEnd) {
        this.availabilityEnd = availabilityEnd;
    }

    public Interval getAvailability() {
        return Interval.of(getAvailabilityStart(), getAvailabilityEnd());
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

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getPriceList() {
        return priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

}
