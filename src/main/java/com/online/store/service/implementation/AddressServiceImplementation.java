package com.online.store.service.implementation;

import com.online.store.entity.Address;
import com.online.store.repository.AddressRepository;
import com.online.store.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Address findOne(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address Not Found"));
    }

    @Override
    public void save(Address address) {
        addressRepository.saveAndFlush(address);
    }

    @Override
    public void update(Address address) {

            Address oldAddress = findOne(address.getId());
            oldAddress.setCountry(address.getCountry());
            oldAddress.setCity(address.getCity());
            oldAddress.setStreet(address.getStreet());
            oldAddress.setZip(address.getZip());
            oldAddress.setCode(address.getCode());

           save(oldAddress);

    }

    @Override
    public void delete(Long id) {
        Address address = findOne(id);
        address.setActive(false);
        save(address);
    }

    @Override
    public void restore(Long id){
        Address address = findOne(id);
        address.setActive(true);
        save(address);
    }

}
