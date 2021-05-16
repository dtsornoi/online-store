package com.online.store.repository;

import com.online.store.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Author.class
 *
 * @author Mark Salumaa
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
