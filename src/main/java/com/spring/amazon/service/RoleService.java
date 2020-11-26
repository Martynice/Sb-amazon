package com.spring.amazon.service;

import com.spring.amazon.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String roleName);
}
