package com.online.store.repository;

import com.online.store.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Orders.class
 *
 * @author Mark Salumaa
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
