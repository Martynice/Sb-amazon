package com.spring.amazon.service;

import com.spring.amazon.model.Review;
import java.util.List;

public interface ReviewService {
    void saveAll(List<Review> reviews);
}
