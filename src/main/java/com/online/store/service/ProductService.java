package com.online.store.service;

import com.online.store.entity.Product;

import java.util.List;

/**
 * Service interface for Product.class
 *
 * @author Dmitri Tsornoi
 */
public interface ProductService {
    List<Product> findAllActive();

    List<Product> findAll();

    List<Product> findByCategoryId(Long id);

    Product findOne(Long id);

    void save(Product product);

    void update(Product product);

    void delete(Long id);

    void restore(Long id);
}
