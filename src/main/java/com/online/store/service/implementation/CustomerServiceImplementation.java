package com.online.store.service.implementation;

import com.online.store.entity.Customer;
import com.online.store.repository.CustomerRepository;
import com.online.store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Customer.class
 *
 * @author Mark Salumaa
 */

@Service
public class CustomerServiceImplementation implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOne(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public void save(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void update(Customer customer) {
        Customer oldCustomer = findOne(customer.getId());
        oldCustomer.setAuthor(customer.getAuthor());
        oldCustomer.setUserAccount(customer.getUserAccount());
        save(customer);
    }

    
    @Override
    public void delete(Long id) {
        Customer customer = findOne(id);
        customer.setActive(false);
        save(customer);
    }

    @Override
    public void restore(Long id){
        Customer customer = findOne(id);
        customer.setActive(true);
        save(customer);
    }

}
