package com.online.store.service;

import com.online.store.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();

    Optional<Customer> findOne();

    Customer save(Customer customer);

    Customer update(Long id, Customer customer);

    Customer delete(Long id);
}
