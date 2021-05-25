package com.online.store.repository;


import com.online.store.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Customer.class
 *
 * @author Mark Salumaa
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
