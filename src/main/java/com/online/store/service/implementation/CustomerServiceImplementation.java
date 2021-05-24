package com.online.store.service.implementation;

import com.online.store.entity.Address;
import com.online.store.entity.Author;
import com.online.store.entity.Customer;
import com.online.store.entity.UserAccount;
import com.online.store.repository.AddressRepository;
import com.online.store.repository.AuthorRepository;
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
    private final AuthorRepository authorRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository, UserAccountRepository userAccountRepository, AuthorRepository authorRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.userAccountRepository = userAccountRepository;
        this.authorRepository = authorRepository;
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
    public Customer update(Customer customer) {
        Customer oldCustomer = findOne(customer.getId());

        UserAccount userAccount = getUserAccount(customer);

        Author author = getAuthor(customer);

        oldCustomer.setAuthor(author);
        oldCustomer.setUserAccount(userAccount);

        return customerRepository.saveAndFlush(oldCustomer);
    }

    private Author getAuthor(Customer customer) {
        Author author = authorRepository.getOne(customer.getAuthor().getId());
        author.setFirstName(customer.getAuthor().getFirstName());
        author.setLastName(customer.getAuthor().getLastName());
        author.setActive(customer.getAuthor().isActive());
        return author;
    }

    private UserAccount getUserAccount(Customer customer) {
        UserAccount userAccount = userAccountRepository.getOne(customer.getUserAccount().getId());
        Address address = addressRepository.getOne(userAccount.getAddress().getId());

        userAccount.setAddress(address);
        userAccount.setAvatar(customer.getUserAccount().getAvatar());
        userAccount.setLogin(customer.getUserAccount().getLogin());
        userAccount.setPassword(customer.getUserAccount().getPassword());
        userAccount.setRoles(customer.getUserAccount().getRoles());
        return userAccount;
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
