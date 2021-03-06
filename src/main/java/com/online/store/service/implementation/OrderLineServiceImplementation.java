package com.online.store.service.implementation;

import com.online.store.entity.OrderLine;
import com.online.store.repository.OrderLineRepository;
import com.online.store.service.OrderLineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for OrderLine.class
 *
 * @author Dmitri Tsornoi
 */
@Service
public class OrderLineServiceImplementation implements OrderLineService {

    private OrderLineRepository orderLineRepository;

    public OrderLineServiceImplementation(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }


    @Override
    public List<OrderLine> findAll() {
        return orderLineRepository.findAll().stream().filter(orderLine -> orderLine.getIsActive()).collect(Collectors.toList());
    }

    @Override
    public OrderLine findOne(Long id) {
        return orderLineRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderLine not found"));
    }

    @Override
    public void save(OrderLine orderLine) {
        orderLineRepository.saveAndFlush(orderLine);
    }

    @Override
    public void update(OrderLine orderLine) {
        OrderLine oldOlderLine = findOne(orderLine.getId());
        oldOlderLine.setProduct(orderLine.getProduct());
        oldOlderLine.setQuantityOfProducts(orderLine.getQuantityOfProducts());
        save(oldOlderLine);
    }

    @Override
    public void delete(Long id) {
        OrderLine orderLine = findOne(id);
        orderLine.setIsActive(false);
        save(orderLine);
    }

    @Override
    public void restore(OrderLine orderLine) {
        OrderLine upcomingOrderLine = findOne(orderLine.getId());
        upcomingOrderLine.setIsActive(true);
        orderLineRepository.saveAndFlush(orderLine);
    }

    @Override
    public void quantityPlus(Long id) {
        OrderLine orderLine = findOne(id);
        orderLine.setQuantityOfProducts(orderLine.getQuantityOfProducts()+1);
        save(orderLine);
    }

    @Override
    public void quantityMinus(Long id) {
        OrderLine orderLine = findOne(id);
        orderLine.setQuantityOfProducts(orderLine.getQuantityOfProducts()-1);
        save(orderLine);
    }

    @Override
    public List<OrderLine> findByIsActiveTrueAndUserAccountId(Long id) {
        return orderLineRepository.findByIsActiveTrueAndUserAccountId(id);
    }
}
