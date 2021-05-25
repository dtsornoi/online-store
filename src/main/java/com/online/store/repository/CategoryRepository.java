package com.online.store.repository;

import com.online.store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Category.class
 *
 * @author Mark Salumaa
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
