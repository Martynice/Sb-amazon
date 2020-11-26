package com.spring.amazon.mapper;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review mapToReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setHelpfulnessNumerator(reviewDto.getHelpfulnessNumerator());
        review.setHelpfulnessDenominator(reviewDto.getHelpfulnessDenominator());
        review.setScore(reviewDto.getScore());
        review.setTime(reviewDto.getTime());
        review.setSummary(reviewDto.getSummary());
        review.setText(reviewDto.getText());
        return review;
    }
}
