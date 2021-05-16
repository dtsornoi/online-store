package com.online.store.service;

import com.online.store.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    void save(Customer customer);

    void update(Customer customer);

    void delete(Long id);

    void restore(Long id);
}
