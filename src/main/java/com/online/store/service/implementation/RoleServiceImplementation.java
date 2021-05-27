package com.online.store.service.implementation;

import com.online.store.entity.Role;
import com.online.store.entity.RoleType;
import com.online.store.repository.RoleRepository;
import com.online.store.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for service control class
 *
 * @author Mark Salumaa
 */

@Service
public class RoleServiceImplementation implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImplementation(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findOne(Long id) {
        return roleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role Not Found"));
    }

    @Override
    public Role findByName(RoleType role) {
        return roleRepository.findByName(role);
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
}
