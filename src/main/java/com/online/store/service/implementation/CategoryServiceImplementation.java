package com.online.store.service.implementation;

import com.online.store.entity.Category;
import com.online.store.repository.CategoryRepository;
import com.online.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface implementation for Category.class
 *
 * @author Dmitri Tsornoi
 */
@Service
public class CategoryServiceImplementation implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findOne(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public void save(Category category) {
        categoryRepository.saveAndFlush(category);
    }


}
