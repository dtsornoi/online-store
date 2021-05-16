package com.online.store.service;

import com.online.store.entity.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<Orders> findAll();

    Orders save(Orders order);

    Orders update(Long id, Orders orders);

    Optional<Orders> findOne(Long id);

    Optional<Orders> delete(Long id);
}
