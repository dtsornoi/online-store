package com.online.store.controller;

import com.online.store.entity.Orders;
import com.online.store.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable("id") long id) {
        Orders order = ordersService.findOne(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createOrder(@RequestBody Orders orders){
        ordersService.save(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateOrder(@RequestBody Orders orders){
        ordersService.update(orders);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") long id){
        ordersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") long id){
        ordersService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
