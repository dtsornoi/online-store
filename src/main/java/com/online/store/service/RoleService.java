package com.online.store.service;

import com.online.store.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findAll();

    Role findOne(Long id);

    void save(Role role);

    void update(Role role);

    void delete(Long id);

    void restore(Long id);
}
