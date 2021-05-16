package com.online.store.service.implementation;

import com.online.store.entity.Orders;
import com.online.store.repository.OrdersRepository;
import com.online.store.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrdersService {

    private OrdersRepository ordersRepository;

    @Autowired
    public OrderServiceImplementation(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Orders> findAll() {
        return null;
    }

    @Override
    public Orders save(Orders order) {
        return null;
    }

    @Override
    public Orders update(Long id, Orders orders) {
        return null;
    }

    @Override
    public Optional<Orders> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Orders> delete(Long id) {
        return Optional.empty();
    }
}
