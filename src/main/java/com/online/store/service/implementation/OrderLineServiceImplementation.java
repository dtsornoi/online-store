package com.online.store.service.implementation;

import com.online.store.entity.OrderLine;
import com.online.store.repository.OrderLineRepository;
import com.online.store.service.OrderLineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLineServiceImplementation implements OrderLineService {

    private OrderLineRepository orderLineRepository;

    public OrderLineServiceImplementation(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public List<OrderLine> findLine() {
        return null;
    }

    @Override
    public Optional<OrderLine> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public OrderLine save(OrderLine orderLine) {
        return null;
    }

    @Override
    public OrderLine update(Long id, OrderLine orderLine) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
