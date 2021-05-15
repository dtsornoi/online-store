package com.online.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * Entity class Order
 *
 * @author Vladimir
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String userName;

    double totalCost;

    String deliveryAddress;

    Date dateOfOrder;

    @OneToMany
    private List<OrderLine> orderLines;

    @ManyToOne
    private Customer customer;

    String status;


}
