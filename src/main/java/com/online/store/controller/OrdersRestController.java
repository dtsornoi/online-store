package com.online.store.controller;

import com.online.store.entity.Orders;
import com.online.store.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Order controller
 *
 * @author Vladimir
 */

@RestController
@RequestMapping("/api/orders")
public class OrdersRestController {

    private OrdersService ordersService;

    @Autowired
    public OrdersRestController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Orders>> getAllOrders(){
        List<Orders> orders = ordersService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders){
        Orders responseOrders = ordersService.save(orders);
        return new ResponseEntity<>(responseOrders, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable("id") long id, @RequestBody Orders orders){
        Optional<Orders> oldOrder = ordersService.findOne(id);
        if (oldOrder.isPresent()) {
            Orders oldOrdersItem = oldOrder.get();
            oldOrdersItem.setCustomer(orders.getCustomer());
            oldOrdersItem.setDeliveryAddress(orders.getDeliveryAddress());
            Orders responseOrder = ordersService.save(oldOrdersItem);

            return new ResponseEntity<>(responseOrder,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable("id") long id) {
        Optional<Orders> orderData = ordersService.findOne(id);
        if (orderData.isPresent()) {
            return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") long id){
        try {
            ordersService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
