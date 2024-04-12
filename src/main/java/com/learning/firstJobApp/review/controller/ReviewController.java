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
//for this companyId we haev to provide @PathVariable Long companyId to every method signature
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
        return new ResponseEntity<>(service.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
       boolean isReviewUpdated= service.updateReview(companyId, reviewId, review);
       if (isReviewUpdated) {
           return new ResponseEntity<>("review updated successfully", HttpStatus.OK);
       }
       else{
           return new ResponseEntity<>("review not updated", HttpStatus.NOT_FOUND);

       }
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isReviewDeleted= service.deleteReview(companyId, reviewId);
        if (isReviewDeleted) {
            return new ResponseEntity<>("review deleted successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("review not deleted", HttpStatus.NOT_FOUND);

        }
    }

}


