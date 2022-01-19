package com.isa35.isa3.repository;

import com.isa35.isa3.model.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabinRepository extends JpaRepository<Cabin, Long> {
}
