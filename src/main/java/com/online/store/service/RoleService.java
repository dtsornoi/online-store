package com.online.store.service;

import com.online.store.entity.Role;
import com.online.store.entity.RoleType;

import java.util.List;

/**
 * Service interface for Role.class
 *
 * @author Mark Salumaa
 */

public interface RoleService {
    List<Role> findAll();

    Role findOne(Long id);

    Role findByName(RoleType role);

    void save(Role role);

    void update(Role role);
}
