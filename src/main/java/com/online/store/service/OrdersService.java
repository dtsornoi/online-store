package com.online.store.service;

import com.online.store.entity.Orders;

import java.util.List;

/**
 * Service interface for Orders.class
 *
 * @author Dmitri Tsornoi
 */
public interface OrdersService {

    List<Orders> findAll();

    Orders findOne(Long id);

    void save(Orders order);

    void update(Orders orders);

    void delete(Long id);

    void restore(Long id);

    List<Orders> findByUserAccountId(Long id);
}
