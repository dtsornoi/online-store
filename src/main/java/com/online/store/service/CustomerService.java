package com.online.store.service;

import com.online.store.entity.Customer;

import java.util.List;

/**
 * Service interface for Customer.class
 *
 * @author Mark Salumaa
 */

public interface CustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    void save(Customer customer);

    Customer update(Customer customer);

    void delete(Long id);

    void restore(Long id);
}
