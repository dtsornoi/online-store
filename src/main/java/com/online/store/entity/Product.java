package com.online.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 1, max = 50)
    private String title;

    @NotBlank
    @Size(min = 1, max = 150)
    private String description;

    @NotNull
    private double price;

    @NotNull
    private Long quantity;

    private String image;

    private Boolean isActive;

    private Long availableQuantity;

    @ManyToOne
    @NotNull
    private Category category;

    @ManyToOne
    @NotNull
    private UserAccount userAccount;

    @OneToMany
    private List<Images> images;

    private Long mainImageId;

}
