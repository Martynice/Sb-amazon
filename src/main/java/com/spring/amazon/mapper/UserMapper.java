package com.spring.amazon.mapper;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.model.Role;
import com.spring.amazon.model.User;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static final String PASSWORD = "1111";
    private static final String ROLE_NAME = "USER";

    public User mapToUser(ReviewDto reviewDto) {
        User user = new User();
        user.setExternalId(reviewDto.getUserId());
        user.setProfileName(reviewDto.getProfileName());
        user.setPassword(PASSWORD);
        user.setRoles(Set.of(Role.of(ROLE_NAME)));
        return user;
    }
}
