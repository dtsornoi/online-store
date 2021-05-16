package com.online.store.controller;

import com.online.store.entity.OrderLine;
import com.online.store.service.OrderLineService;
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
@RequestMapping("/api/orderline")
public class OrderLineRestController {
    private OrderLineService orderLineService;

    @Autowired
    public OrderLineRestController(OrderLineService orderLineService){
        this.orderLineService = orderLineService;
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderLine>> getAllOrderLines(){
        List<OrderLine> orderLines = orderLineService.findAll();
        return new ResponseEntity<>(orderLines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderLine> getOrderLineById(@PathVariable("id") long id) {
        OrderLine orderLine = orderLineService.findOne(id);
        return new ResponseEntity<>(orderLine, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createOrderLine(@RequestBody OrderLine orderLine){
        orderLineService.save(orderLine);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateOrderLine(@RequestBody OrderLine orderLine){
        orderLineService.update(orderLine);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrderLine(@PathVariable("id") long id){
        orderLineService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> restoreOrderLine(@PathVariable("id") long id){
        orderLineService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
