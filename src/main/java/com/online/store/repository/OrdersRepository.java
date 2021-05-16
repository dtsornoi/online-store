package com.online.store.repository;

import com.online.store.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Orders.class
 *
 * @author Mark Salumaa
 */
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
