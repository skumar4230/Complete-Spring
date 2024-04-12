package com.learning.firstJobApp.review.controller;

import com.learning.firstJobApp.review.entity.Review;
import com.learning.firstJobApp.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies/{companyId}")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(service.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean isReviewSaved = service.addReview(companyId, review);
        if (isReviewSaved) {

            return new ResponseEntity<>("review added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("review not saved", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return  new ResponseEntity<>(service.getReview(companyId, reviewId),HttpStatus.OK);
    }
}


