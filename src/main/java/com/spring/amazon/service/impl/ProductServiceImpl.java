package com.spring.amazon.service.impl;

import com.spring.amazon.model.Product;
import com.spring.amazon.repository.ProductRepository;
import com.spring.amazon.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveAll(List<Product> products) {
        productRepository.saveAll(products);
    }

    @Override
    public Product getByExternalId(String id) {
        return productRepository.getByExternalId(id).get();
    }
}
