package com.spring.amazon.mapper;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToProduct(ReviewDto reviewDto) {
        Product product = new Product();
        product.setExternalId(reviewDto.getProductId());
        return product;
    }
}
