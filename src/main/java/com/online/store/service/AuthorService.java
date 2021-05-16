package com.online.store.service;

import com.online.store.entity.Author;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for Author.class
 *
 * @author Dmitri Tsornoi
 */
public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findOne(Long id);

    Author save(Author customer);

    Author update(Long id, Author author);

    void delete(Long id, Author author);
}
