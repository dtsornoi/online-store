package com.online.store.service;

import com.online.store.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findOne();

    Author save(Author customer);

    Author update(Long id, Author customer);

    Author delete(Long id);
}
