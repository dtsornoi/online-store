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

    Author findOne(Long id);

    void save(Author author);

    void update(Author author);

    void delete(Long id);

    void restore(Long id);
}
