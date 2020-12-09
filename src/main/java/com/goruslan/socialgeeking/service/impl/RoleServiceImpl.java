package com.goruslan.socialgeeking.service.impl;

import com.goruslan.socialgeeking.domain.Role;
import com.goruslan.socialgeeking.repository.RoleRepository;
import com.goruslan.socialgeeking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private  RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
