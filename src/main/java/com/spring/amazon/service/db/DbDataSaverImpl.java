package com.spring.amazon.service.db;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.mapper.ProductMapper;
import com.spring.amazon.mapper.ReviewMapper;
import com.spring.amazon.mapper.UserMapper;
import com.spring.amazon.model.Product;
import com.spring.amazon.model.Review;
import com.spring.amazon.model.User;
import com.spring.amazon.service.ProductService;
import com.spring.amazon.service.ReviewService;
import com.spring.amazon.service.RoleService;
import com.spring.amazon.service.UserService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DbDataSaverImpl implements DbDataSaver<ReviewDto> {
    private static final String PASSWORD = "1111";
    private static final String ROLE_NAME = "USER";
    private final UserService userService;
    private final ProductService productService;
    private final ReviewService reviewService;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final ReviewMapper reviewMapper;

    public DbDataSaverImpl(UserService userService, ProductService productService,
                           ReviewService reviewService, RoleService roleService,
                           UserMapper userMapper, ProductMapper productMapper,
                           ReviewMapper reviewMapper) {
        this.userService = userService;
        this.productService = productService;
        this.reviewService = reviewService;
        this.roleService = roleService;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public List<User> saveUsers(List<ReviewDto> data) {
        List<User> users = data.stream()
                .map(userMapper::mapToUser)
                .peek(x -> {
                    x.setRoles(Set.of(roleService.getByName(ROLE_NAME)));
                    x.setPassword(PASSWORD);
                })
                .collect(Collectors.toList());
        userService.saveAll(users);
        return users;
    }

    @Override
    public List<Product> saveProducts(List<ReviewDto> data) {
        List<Product> products = data.stream()
                .map(productMapper::mapToProduct)
                .collect(Collectors.toList());
        productService.saveAll(products);
        return products;
    }

    @Override
    public List<Review> saveReviews(List<ReviewDto> data) {
        List<Review> reviews = data.stream()
                .map(reviewMapper::mapToReview)
                .collect(Collectors.toList());
        reviewService.saveAll(reviews);
        return reviews;
    }
}
