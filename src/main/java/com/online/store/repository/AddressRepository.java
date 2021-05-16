package com.online.store.repository;

import com.online.store.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Address.class
 *
 * @author Mark Salumaa
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
