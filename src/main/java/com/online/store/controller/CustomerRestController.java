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
@CrossOrigin(origins = "*")
public class CustomerRestController {

    private final CustomerService customerService;

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
     * POST:<code>/</code>
     *
     * @param customer from UI to be persisted to DB
     * @return HttpStatus 201
     */
    @PostMapping("/")
    public ResponseEntity<HttpStatus> createCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * PUT:<code>/</code>
     *
     * @param customer from UI to be updated to DB
     * @return HttpStatus 200
     */
    @PutMapping("/")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer upcomingCustomer = customerService.update(customer);
        return new ResponseEntity<>(upcomingCustomer ,HttpStatus.OK);
    }

    /**
     * POST:<code>/delete/id</code>
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
     * POST:<code>/restore/id</code>
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
