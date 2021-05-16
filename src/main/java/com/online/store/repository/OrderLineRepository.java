package com.online.store.repository;

import com.online.store.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for OrderLine.class
 *
 * @author Mark Salumaa
 */
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
