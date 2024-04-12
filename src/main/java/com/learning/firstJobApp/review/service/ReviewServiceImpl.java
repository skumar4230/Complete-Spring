package com.learning.firstJobApp.review.service;

import com.learning.firstJobApp.company.entity.Company;
import com.learning.firstJobApp.company.service.CompanyService;
import com.learning.firstJobApp.review.entity.Review;
import com.learning.firstJobApp.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    //    @Autowired
    //    private CompanyRepository companyRepository;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        //        Company company = companyRepository.findById(companyId).get();
        List<Review> reviewList = reviewRepository.findByCompanyId(companyId);
        return reviewList;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {return false;}
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        return reviews.stream()
                .filter(review->review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);

    }
}