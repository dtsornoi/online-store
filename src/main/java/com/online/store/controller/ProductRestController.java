package com.online.store.controller;

import com.online.store.entity.Product;
import com.online.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Product controller
 *
 * @author Vladimir
 */

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * GET:<code>/</code>
     *
     * @return List of all Products
     */
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> orders = productService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * GET:<code>/active</code>
     *
     * @return List of all Active Products
     */
    @GetMapping("/active")
    public ResponseEntity<List<Product>> getAllActiveProducts() {
        List<Product> orders = productService.findAllActive();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * GET:<code>/id</code>
     *
     * @param id of type Long for searching Product by Id in DB
     * @return Order with with specified Id and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        Product product = productService.findOne(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * GET:<code>/filter/id</code>
     *
     * @param id of type Long for searching Product by Id in DB
     * @return Order with with specified Id and HttpStatus.OK
     */
    @GetMapping("/filter/{id}")
    public ResponseEntity<List<Product>> findByCategoryId(@PathVariable("id") long id) {
        List<Product> products = productService.findByCategoryId(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * POST:<code>/</code>
     *
     * @param product from UI to be persisted to DB
     * @return HttpStatus 201
     */
    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product upcomingProduct = productService.save(product);
        return new ResponseEntity<>(upcomingProduct, HttpStatus.CREATED);
    }

    /**
     * PUT:<code>/</code>
     *
     * @param product from UI to be updated to DB
     * @return HttpStatus 200
     */
    @PutMapping("/")
    public ResponseEntity<HttpStatus> updateOrder(@RequestBody Product product) {
        productService.update(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/delete/id</code>
     *
     * @param id of type Long for deleting Product by Id in DB
     * @return HttpStatus 200
     */
    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/restore/id</code>
     *
     * @param id of type Long for restoring Product by Id in DB
     * @return HttpStatus 200
     */
    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> restoreProduct(@PathVariable("id") Long id) {
        productService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
