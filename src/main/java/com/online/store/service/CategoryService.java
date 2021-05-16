package com.online.store.service;

import com.online.store.entity.Category;

import java.util.List;

/**
 * Service Interface for Category.class
 *
 * @author Dmitri Tsornoi
 */
public interface CategoryService {

    List<Category> findAll();

    Category findOne(Long id);

    void save(Category category);
}
