package com.online.store.repository;


import com.online.store.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Customer.class
 *
 * @author Mark Salumaa
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
