package com.online.store.entity;

import lombok.AllArgsConstructor;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantityOfProducts;

    private boolean isActive;

    @ManyToOne
    private Product product;
}
