package com.spring.amazon.service.impl;

import com.spring.amazon.model.Review;
import com.spring.amazon.repository.ReviewRepository;
import com.spring.amazon.service.ReviewService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void saveAll(List<Review> reviews) {
        reviewRepository.saveAll(reviews);
    }
}
