package com.online.store.repository;

import com.online.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Product.class
 *
 * @author Mark Salumaa
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
