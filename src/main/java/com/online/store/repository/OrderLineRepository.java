package com.online.store.repository;

import com.online.store.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for OrderLine.class
 *
 * @author Mark Salumaa
 */
@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
