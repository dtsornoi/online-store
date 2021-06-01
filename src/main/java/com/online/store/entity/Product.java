package com.online.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    private double price;

    private Long quantity;

    private boolean isActive;

    private Long availableQuantity;

    @ManyToOne
    private Category category;

    @ManyToOne
    private UserAccount userAccount;

    @OneToMany
    private List<Image> images;
}
