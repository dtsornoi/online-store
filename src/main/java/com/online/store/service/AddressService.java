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

    Address findOne(Long id);

    void save(Address address);

    void update(Address address);

    void delete(Long id);

    void restore(Long id);
}
