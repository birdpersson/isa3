package com.isa35.isa3.controller;

import com.isa35.isa3.dto.ReviewResponse;
import com.isa35.isa3.model.Review;
import com.isa35.isa3.security.TokenUtils;
import com.isa35.isa3.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public ResponseEntity<List<ReviewResponse>> getReviews() {
        List<Review> reviews = reviewService.findAll();
        List<ReviewResponse> list = new ArrayList<>();
        for (Review r : reviews) {
            if (r.getStatus().equals(Review.Status.PENDING))
                list.add(new ReviewResponse(r));
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<ReviewResponse> acceptReview(@PathVariable String id) {
        Review review = reviewService.findById(Long.parseLong(id));
        return new ResponseEntity<>(new ReviewResponse(reviewService.accept(review)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<ReviewResponse> rejectReview(@PathVariable String id) {
        Review review = reviewService.findById(Long.parseLong(id));
        return new ResponseEntity<>(new ReviewResponse(reviewService.reject(review)), HttpStatus.CREATED);
    }

}
