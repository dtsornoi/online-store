package com.online.store.repository;

import com.online.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Product.class
 *
 * @author Mark Salumaa
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
