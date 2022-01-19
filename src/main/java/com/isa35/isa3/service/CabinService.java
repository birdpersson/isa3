package com.isa35.isa3.service;

import com.isa35.isa3.dto.CabinDTO;
import com.isa35.isa3.model.Cabin;
import com.isa35.isa3.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public Cabin findById(Long id) {
        return cabinRepository.findById(id).orElseGet(null);
    }

    public List<Cabin> findAll() {
        return cabinRepository.findAll();
    }

    public Cabin create(CabinDTO dto) {
        Cabin c = new Cabin();
        c.setName(dto.getName());
        c.setAddress(dto.getAddress());
        c.setDescription(dto.getDescription());
        c.setAvailableForm(dto.getAvailableFrom());
        c.setAvailableTo(dto.getAvailableTo());
        c.setPriceList(dto.getPriceList());
        c.setRules(dto.getRules());
        c.setRooms(dto.getRooms());
        c.setBeds(dto.getBeds());
        return cabinRepository.save(c);
    }

}
