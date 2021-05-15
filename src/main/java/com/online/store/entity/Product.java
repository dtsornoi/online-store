package com.online.store.entity;

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
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String thumbnail;

    private double price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Author author;
}
