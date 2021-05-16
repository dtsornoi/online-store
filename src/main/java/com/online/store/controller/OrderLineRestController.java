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
@RequestMapping("/api/order-line")
public class OrderLineRestController {
    private OrderLineService orderLineService;

    @Autowired
    public OrderLineRestController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    /**
     * GET:<code>/</code>
     *
     * @return List of all OrderLines
     */
    @GetMapping("/")
    public ResponseEntity<List<OrderLine>> getAllOrderLines() {
        List<OrderLine> orderLines = orderLineService.findAll();
        return new ResponseEntity<>(orderLines, HttpStatus.OK);
    }

    /**
     * GET:<code>/id</code>
     *
     * @param id of type Long for searching OrderLine by Id in DB
     * @return OrderLine with with specified Id and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrderLine> getOrderLineById(@PathVariable("id") long id) {
        OrderLine orderLine = orderLineService.findOne(id);
        return new ResponseEntity<>(orderLine, HttpStatus.OK);
    }

    /**
     * POST:<code>/create</code>
     *
     * @param orderLine from UI to be persisted to DB
     * @return HttpStatus 201
     */
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createOrderLine(@RequestBody OrderLine orderLine) {
        orderLineService.save(orderLine);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * PUT:<code>/update</code>
     *
     * @param orderLine from UI to be updated to DB
     * @return HttpStatus 200
     */
    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateOrderLine(@RequestBody OrderLine orderLine) {
        orderLineService.update(orderLine);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/delete/id</code>
     *
     * @param id of type Long for deleting OrderLine by Id in DB
     * @return HttpStatus 200
     */
    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrderLine(@PathVariable("id") long id) {
        orderLineService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/restore/id</code>
     *
     * @param id of type Long for restoring OrderLine by Id in DB
     * @return HttpStatus 200
     */
    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> restoreOrderLine(@PathVariable("id") long id) {
        orderLineService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
