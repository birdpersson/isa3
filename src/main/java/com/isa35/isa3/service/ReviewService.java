package com.isa35.isa3.service;

import com.isa35.isa3.dto.ReviewDTO;
import com.isa35.isa3.model.Cabin;
import com.isa35.isa3.model.Review;
import com.isa35.isa3.model.User;
import com.isa35.isa3.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository repository;

    public Review findById(Long id) {
        return repository.findById(id).orElseGet(null);
    }

    public List<Review> findAll() {
        return repository.findAll();
    }

    public Review create(User guest, Cabin cabin, ReviewDTO dto) {
        Review r = new Review();
        r.setStatus(Review.Status.PENDING);
        r.setComment(dto.getComment());
        r.setRating(dto.getRating());
        r.setCabin(cabin);
        r.setGuest(guest);
        cabin.addReview(r);
        guest.addReview(r);
        return repository.save(r);
    }

    public Review accept(Review r) {
        r.setStatus(Review.Status.ACCEPTED);
        return repository.save(r);
    }

    public Review reject(Review r) {
        r.setStatus(Review.Status.REJECTED);
        return repository.save(r);
    }
}
