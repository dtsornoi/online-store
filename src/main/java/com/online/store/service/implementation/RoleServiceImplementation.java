package com.online.store.service.implementation;

import com.online.store.entity.Role;
import com.online.store.repository.RoleRepository;
import com.online.store.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImplementation implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImplementation(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role findOne(Long id) {
        return roleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role Not Found"));
    }

    @Override
    public void save(Role role) {
        roleRepository.saveAndFlush(role);
    }

    @Override
    public void update(Role role) {
        Role oldRole = findOne(role.getId());
        oldRole.setName(role.getName());

        save(role);
    }

    @Override
    public void delete(Long id) {
        Role role = findOne(id);
        role.setActive(false);
        save(role);

    }

    @Override
    public void restore(Long id) {
        Role role = findOne(id);
        role.setActive(true);
        save(role);
    }
}
