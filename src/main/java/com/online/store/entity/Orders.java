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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private Double totalCost;

    private String deliveryAddress;

    private Date dateOfOrder;

    private String status;

    private boolean isActive;

    @OneToMany
    private List<OrderLine> orderLines;

    @ManyToOne
    private UserAccount userAccount;

}
