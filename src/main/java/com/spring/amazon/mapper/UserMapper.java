package com.spring.amazon.mapper;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser(ReviewDto reviewDto) {
        User user = new User();
        user.setExternalId(reviewDto.getUserId());
        user.setProfileName(reviewDto.getProfileName());
        return user;
    }
}
