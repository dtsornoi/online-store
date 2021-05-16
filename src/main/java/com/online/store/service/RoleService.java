package com.online.store.service;

import com.online.store.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findAll();

    Optional<Role> findOne(Long id);

    Role save(Role role);

    void delete(Long id);
}
