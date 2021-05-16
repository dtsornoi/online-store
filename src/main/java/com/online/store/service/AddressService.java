package com.online.store.service;

import com.online.store.entity.Address;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for Address.class
 *
 * @author Dmitri Tsornoi
 */
public interface AddressService {
    List<Address> findAll();

    Optional<Address> findOne(Long id);

    Address save(Address address);

    Address update(Long id, Address address);

    Address delete(Long id, Address address);
}
