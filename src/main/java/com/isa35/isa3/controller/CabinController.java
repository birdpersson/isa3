package com.isa35.isa3.controller;

import com.isa35.isa3.dto.CabinDTO;
import com.isa35.isa3.model.Cabin;
import com.isa35.isa3.security.TokenUtils;
import com.isa35.isa3.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabin")
public class CabinController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private CabinService cabinService;

    @GetMapping("/")
    public ResponseEntity<List<Cabin>> getCabins() {
        return new ResponseEntity<>(cabinService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cabin> getCabin(@PathVariable String id) {
        return new ResponseEntity<>(cabinService.findById(Long.parseLong(id)), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Cabin> createCabin(@RequestBody CabinDTO cabinDTO) {
        return new ResponseEntity<>(cabinService.create(cabinDTO), HttpStatus.CREATED);
    }

}
