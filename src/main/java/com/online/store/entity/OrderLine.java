package com.online.store.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


/**
 *  POJO for Order Line entity
 *
 * @author Mark Salumaa
 */

@Entity
@Table(name = "order_line")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "quantity_of_products")
    private long quantityOfProducts;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
