package com.online.store.service.implementation;

import com.online.store.entity.Address;
import com.online.store.entity.Customer;
import com.online.store.entity.UserAccount;
import com.online.store.repository.AddressRepository;
import com.online.store.repository.CustomerRepository;
import com.online.store.repository.UserAccountRepository;
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

    private final CustomerRepository customerRepository;
    private final UserAccountRepository userAccountRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository, UserAccountRepository userAccountRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.userAccountRepository = userAccountRepository;
        this.addressRepository = addressRepository;
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
        oldCustomer.setUserAccount(customer.getUserAccount());
        oldCustomer.setAddress(customer.getAddress());
        save(customer);
    }

//    private UserAccount getUserAccount(Customer customer) {
//        UserAccount userAccount = userAccountRepository.getOne(customer.getUserAccount().getId());
//        Address address = addressRepository.getOne(customer.getAddress().getId());
//
//        userAccount.setAvatar(customer.getUserAccount().getAvatar());
//        userAccount.setLogin(customer.getUserAccount().getLogin());
//        userAccount.setPassword(customer.getUserAccount().getPassword());
//        userAccount.setRoles(customer.getUserAccount().getRoles());
//        return userAccount;
//    }
    
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
