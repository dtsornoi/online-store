package com.online.store.controller;

import com.online.store.entity.Customer;
import com.online.store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Customer controller
 *
 * @author Vladimir
 */

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * GET:<code>/</code>
     *
     * @return List of all Customers
     */
    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /**
     * GET:<code>/id</code>
     *
     * @param id of type Long for searching Customer by Id in DB
     * @return Customer with with specified Id and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
        Customer customer = customerService.findOne(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * GET:<code>/create</code>
     *
     * @param customer from UI to be persisted to DB
     * @return HttpStatus 201
     */
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * GET:<code>/update</code>
     *
     * @param customer from UI to be updated to DB
     * @return HttpStatus 200
     */
    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateCustomer(@RequestBody Customer customer) {
        customerService.update(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * GET:<code>/delete/id</code>
     *
     * @param id of type Long for deleting Customer by Id in DB
     * @return HttpStatus 200
     */
    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * GET:<code>/restore/id</code>
     *
     * @param id of type Long for restoring Customer by Id in DB
     * @return HttpStatus 200
     */
    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> restoreCustomer(@PathVariable("id") long id) {
        customerService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
