package com.online.store.repository;

import com.online.store.entity.Role;
import com.online.store.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Role.class
 *
 * @author Mark Salumaa
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(RoleType name);
}
