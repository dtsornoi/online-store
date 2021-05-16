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
    public ProductRestController (ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> orders = productService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable ("id") long id){
        Product product = productService.findOne(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveProduct(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateOrder(@RequestBody Product product){
        productService.update(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> restoreProduct(@PathVariable("id") long id){
        productService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
