package com.online.store.service;

import com.online.store.entity.Address;
import com.online.store.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImplementation implements AddressService{

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImplementation(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Optional<Address> findOne() {
        return Optional.empty();
    }

    @Override
    public Address save(Address customer) {
        return null;
    }

    @Override
    public Address update(Long id, Address customer) {
        return null;
    }

    @Override
    public Address delete(Long id) {
        return null;
    }
}
