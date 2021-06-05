package com.online.store.controller;

import com.online.store.entity.Category;
import com.online.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Category controller
 *
 * @author Vladimir
 */

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    private CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * GET:<code>/</code>
     *
     * @return List of all Categories
     */
    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> category = categoryService.findAll();
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    /**
     * GET:<code>/id</code>
     *
     * @param id of type Long for searching Category by Id in DB
     * @return Category with with specified Id and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) {
        Category category = categoryService.findOne(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    /**
     * POST:<code>/</code>
     *
     * @param category from UI to be persisted to DB
     * @return HttpStatus 201
     */
    @PostMapping("/")
    public ResponseEntity<HttpStatus> createCategory(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
