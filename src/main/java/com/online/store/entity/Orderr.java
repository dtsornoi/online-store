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
@AllArgsConstructor
@NoArgsConstructor
public class Orderr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private Double totalCost;

    private String deliveryAddress;

    private Date dateOfOrder;

    @OneToMany
    private List<OrderLine> orderLines;

    @ManyToOne
    private Customer customer;

    private String status;
}
