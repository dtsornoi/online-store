package com.online.store.service;

import com.online.store.entity.Category;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for Category.class
 *
 * @author Dmitri Tsornoi
 */
public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findOne(Long id);
}
