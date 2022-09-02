package com.isa35.isa3.service;

import com.isa35.isa3.dto.AmenityRequest;
import com.isa35.isa3.model.Amenity;
import com.isa35.isa3.model.Cabin;
import com.isa35.isa3.repository.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmenityService {

    @Autowired
    AmenityRepository repository;

    public Amenity create(Cabin cabin, AmenityRequest dto) {
        Amenity a = new Amenity();
        a.setName(dto.getName());
        a.setPrice(dto.getPrice());
        a.setCabin(cabin);
        cabin.addAmenity(a);
        return repository.save(a);
    }

}
