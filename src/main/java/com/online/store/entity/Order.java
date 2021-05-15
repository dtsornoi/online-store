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
@Table(name = "user_account")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    String userName;

    @Column(name = "total_cost")
    double totalCost;

    @Column(name = "delivery_address")
    String deliveryAddress;

    @Column(name = "date_of_order")
    Date dateOfOrder;


    @OneToMany(mappedBy = "cart")
    private List<OrderLine> orderLine;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "status")
    String status;


}
