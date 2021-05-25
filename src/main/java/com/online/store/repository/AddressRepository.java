package com.online.store.repository;

import com.online.store.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Address.class
 *
 * @author Mark Salumaa
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
