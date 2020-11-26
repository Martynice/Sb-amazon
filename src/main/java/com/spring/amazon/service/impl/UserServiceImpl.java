package com.spring.amazon.service.impl;

import com.spring.amazon.model.User;
import com.spring.amazon.repository.UserRepository;
import com.spring.amazon.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }
}
