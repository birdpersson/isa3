package com.isa35.isa3.model;

import javax.persistence.*;

@Entity
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int price;

    @Column
    private String name;

    @ManyToOne
    private Cabin cabin;

    @ManyToOne
    private Reservation reservation;


}
