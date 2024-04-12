package com.learning.firstJobApp.review.service;

import com.learning.firstJobApp.review.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId,Review review);
    Review getReview(Long companyId,Long reviewId);

    boolean updateReview(Long companyId ,Long reviewId, Review review);

    boolean deleteReview(Long companyId, Long reviewId);
}
