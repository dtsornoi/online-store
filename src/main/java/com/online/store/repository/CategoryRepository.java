package com.online.store.repository;

import com.online.store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Category.class
 *
 * @author Mark Salumaa
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
