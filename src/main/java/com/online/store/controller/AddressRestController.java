package com.online.store.controller;

import com.online.store.entity.Address;
import com.online.store.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for Address.class
 *
 * @author Dmitri Tsornoi
 */

@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "*")
public class AddressRestController {

    private AddressService addressService;

    @Autowired
    public AddressRestController(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * GET:<code>/</code>
     * @return return all Addresses from DB and status 200
     */
    @GetMapping("/")
    public ResponseEntity<List<Address>> getAllAddressFromDB(){
        List<Address> address = addressService.findAll();

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    /**
     * GET:<code>/id</code>
     * @param id for Address to be found by in DB
     * @return requested Address.class and status 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<Address> findAddressInDBById(@PathVariable("id") Long id){
        Address address = addressService.findOne(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    /**
     * POST:<code>/</code>
     * @param address Address.class from UI to be persisted to DB
     * @return response status of 201
     */
    @PostMapping("/")
    public ResponseEntity<HttpStatus> persistAddressToDB(@RequestBody Address address){
        addressService.save(address);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * PUT:<code>/</code>
     * @param address new Address to be stored in DB instead of the old one
     * @return response status 200
     */
    @PutMapping("/")
    public ResponseEntity<HttpStatus> updateAddressThatIsStoredInDB(@RequestBody Address address){
        addressService.update(address);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/delete/id</code>
     * @param id of the Address to be deleted
     * @return response status of 200
     */
    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id") Long id){
        addressService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/restore/id</code>
     * @param id of the Address to be restored
     * @return response status of 200
     */
    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> restoreAddress(@PathVariable("id") Long id){
        addressService.restore(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
