package com.online.store.service;

import com.online.store.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> findAll();

    Optional<Address> findOne();

    Address save(Address customer);

    Address update(Long id, Address customer);

    Address delete(Long id);
}