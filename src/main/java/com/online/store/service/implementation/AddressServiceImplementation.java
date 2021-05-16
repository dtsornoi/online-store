package com.online.store.service.implementation;

import com.online.store.entity.Address;
import com.online.store.repository.AddressRepository;
import com.online.store.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for Address Service class
 *
 * @author Mark Salumaa
 */

@Service
public class AddressServiceImplementation implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImplementation(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findOne(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, Address address) {
        Optional<Address> optionalAddress = findOne(id);

        if(optionalAddress.isPresent()){
            Address oldAddress = optionalAddress.get();
            oldAddress.setCountry(address.getCountry());
            oldAddress.setCity(address.getCity());
            oldAddress.setStreet(address.getStreet());
            oldAddress.setZip(address.getZip());
            oldAddress.setCode(address.getCode());

            return save(oldAddress);
        } else {
            throw new RuntimeException("Address Not Found!");
        }

    }

    @Override
    public Address delete(Long id, Address address) {
        Optional<Address> optionalAddress = findOne(id);

        if(optionalAddress.isPresent()){
            addressRepository.delete(address);
        } else {

        } throw new RuntimeException("Address Not Found");
    }
}
