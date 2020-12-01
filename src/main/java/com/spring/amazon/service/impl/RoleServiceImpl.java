package com.spring.amazon.service.impl;

import com.spring.amazon.model.Role;
import com.spring.amazon.repository.RoleRepository;
import com.spring.amazon.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.getByRoleName(Role.of(roleName).getRoleName());
    }
}
