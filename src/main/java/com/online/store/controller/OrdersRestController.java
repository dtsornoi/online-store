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

    /**
     * GET:<code>/</code>
     *
     * @return List of all Orders
     */
    @GetMapping("/")
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = ordersService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * GET:<code>/id</code>
     *
     * @param id of type Long for searching Order by Id in DB
     * @return Order with with specified Id and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable("id") long id) {
        Orders order = ordersService.findOne(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /**
     * POST:<code>/</code>
     *
     * @param orders from UI to be persisted to DB
     * @return HttpStatus 201
     */
    @PostMapping("/")
    public ResponseEntity<HttpStatus> createOrder(@RequestBody Orders orders) {
        ordersService.save(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * PUT:<code>/</code>
     *
     * @param orders from UI to be updated to DB
     * @return HttpStatus 200
     */
    @PutMapping("/")
    public ResponseEntity<HttpStatus> updateOrder(@RequestBody Orders orders) {
        ordersService.update(orders);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/delete/id</code>
     *
     * @param id of type Long for deleting Order by Id in DB
     * @return HttpStatus 200
     */
    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") long id) {
        ordersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/restore/id</code>
     *
     * @param id of type Long for restoring Order by Id in DB
     * @return HttpStatus 200
     */
    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> restoreOrder(@PathVariable("id") long id) {
        ordersService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
