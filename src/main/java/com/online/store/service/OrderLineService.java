package com.online.store.service;

import com.online.store.entity.OrderLine;

import java.util.List;
import java.util.Optional;

public interface OrderLineService {

    List<OrderLine> findLine();

    Optional<OrderLine> findOne(Long id);

    OrderLine save(OrderLine orderLine);

    OrderLine update(Long id, OrderLine orderLine);

    void delete(Long id);
}
