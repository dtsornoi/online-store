package com.online.store.service;

import com.online.store.entity.OrderLine;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for OrderLine.class
 *
 * @author Dmitri Tsornoi
 */

public interface OrderLineService {

    List<OrderLine> findAll();

    OrderLine findOne(Long id);

    void save(OrderLine orderLine);

    void update(OrderLine orderLine);

    void delete(Long id);

    void restore(Long id);
}
