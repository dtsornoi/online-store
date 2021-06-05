package com.online.store.service.implementation;

import com.online.store.entity.Orders;
import com.online.store.repository.OrdersRepository;
import com.online.store.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Orders.class
 */
@Service
public class OrdersServiceImplementation implements OrdersService {

    private OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImplementation(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }


    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders findOne(Long id) {
        return ordersRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public void save(Orders order) {
        ordersRepository.saveAndFlush(order);
    }

    @Override
    public void update(Orders orders) {
        Orders oldOrder = findOne(orders.getId());
        oldOrder.setDateOfOrder(orders.getDateOfOrder());
        oldOrder.setOrderLines(orders.getOrderLines());
        oldOrder.setUserAccount(orders.getUserAccount());
        oldOrder.setStatus(orders.getStatus());
        oldOrder.setDeliveryAddress(orders.getDeliveryAddress());
        oldOrder.setTotalCost(orders.getTotalCost());
        oldOrder.setUserName(orders.getUserName());
        oldOrder.setActive(orders.isActive());

        save(oldOrder);
    }


    @Override
    public void delete(Long id) {
        Orders orders = findOne(id);
        orders.setActive(false);
        save(orders);
    }

    @Override
    public void restore(Long id) {
        Orders orders = findOne(id);
        orders.setActive(true);
        save(orders);
    }

    @Override
    public List<Orders> findByUserAccountId(Long id) {
        return ordersRepository.findByUserAccountId(id);
    }
}
