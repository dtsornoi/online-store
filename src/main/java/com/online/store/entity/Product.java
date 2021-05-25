package com.online.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * POJO class for Product Entity
 *
 * @author Mark Salumaa
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private String thumbnail;

    private double price;

    private boolean isActive;

    @ManyToOne
    private Category category;

    @ManyToOne
    private UserAccount userAccount;
}
