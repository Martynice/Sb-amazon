package com.spring.amazon.service.db;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.model.Product;
import com.spring.amazon.model.Review;
import com.spring.amazon.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface DbDataSaver<T> {
    List<User> saveUsers(List<ReviewDto> data);

    List<Product> saveProducts(List<ReviewDto> data);

    List<Review> saveReviews(List<ReviewDto> data);
}
