package com.goruslan.socialgeeking.service;

import com.goruslan.socialgeeking.domain.Role;

public interface RoleService {

    Role findByName(String name);

}
