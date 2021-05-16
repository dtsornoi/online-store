package com.online.store.service;

import com.online.store.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findOne();

    Product save(Product product);

    Product update(Long id, Product product);

    void delete(Long id);
}
