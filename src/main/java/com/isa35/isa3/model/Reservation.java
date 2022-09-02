package com.isa35.isa3.model;

import org.threeten.extra.Interval;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;

@Entity
public class Reservation {
    public enum Type {RESERVATION, PROMOTION}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    public Type type;

    @Column
    private Instant start;

    @Column(name = "finish")
    private Instant end;

    @Column
    private Instant expiry;

    @Column
    private Integer people;

    @Column
    private Integer price;

    @ManyToOne
    private Cabin cabin;

    @ManyToOne
    private User guest;

    @ElementCollection
    private Collection<String> amenities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Interval getInterval() {
        return Interval.of(getStart(), getEnd());
    }

    public void setInterval(Interval interval) {
        this.start = interval.getStart();
        this.end = interval.getEnd();
    }

    public Instant getStart() {
        return start;
    }

    public void setStart(Instant start) {
        this.start = start;
    }

    public Instant getEnd() {
        return end;
    }

    public void setEnd(Instant end) {
        this.end = end;
    }

    public Instant getExpiry() {
        return expiry;
    }

    public void setExpiry(Instant expiry) {
        this.expiry = expiry;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public User getGuest() {
        return guest;
    }

    public void setGuest(User guest) {
        this.guest = guest;
    }

    public Collection<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(Collection<String> amenities) {
        this.amenities = amenities;
    }

}
