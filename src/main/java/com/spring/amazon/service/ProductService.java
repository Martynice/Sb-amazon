package com.spring.amazon.service;

import com.spring.amazon.model.Product;
import java.util.List;

public interface ProductService {
    void saveAll(List<Product> products);

    Product getByExternalId(String productId);
}
