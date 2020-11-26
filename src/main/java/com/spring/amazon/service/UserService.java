package com.spring.amazon.service;

import com.spring.amazon.model.User;
import java.util.List;

public interface UserService {
    void saveAll(List<User> users);
}
