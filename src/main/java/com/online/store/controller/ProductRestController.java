package com.online.store.controller;

import com.online.store.entity.Product;
import com.online.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Order controller
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
    public ResponseEntity<List<Product>> getAllProductss(){
        List<Product> orders = productService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable ("id") long id){
        Optional<Product> productData = productService.findOne(id);
        if (productData.isPresent()){
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product responseProduct = productService.save(product);
        return new ResponseEntity<>(responseProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateOrder(@PathVariable("id") long id, @RequestBody Product product){
        Optional<Product> oldProduct = productService.findOne(id);
        if (oldProduct.isPresent()) {
            Product oldProductItem = oldProduct.get();
            oldProductItem.setDescription(product.getDescription());
            oldProductItem.setAuthor(product.getAuthor());
            oldProductItem.setPrice(product.getPrice());
            oldProductItem.setThumbnail(product.getThumbnail());
            oldProductItem.setTitle(product.getTitle());
            Product responseOrder = productService.save(oldProductItem);
            return new ResponseEntity<>(responseOrder,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id){
        try {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
