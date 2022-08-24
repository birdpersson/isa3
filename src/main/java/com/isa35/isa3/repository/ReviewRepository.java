package com.isa35.isa3.repository;

import com.isa35.isa3.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
