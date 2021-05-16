package com.online.store.service;

import com.online.store.entity.Author;
import com.online.store.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImplementation implements AuthorService{

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public Optional<Author> findOne() {
        return Optional.empty();
    }

    @Override
    public Author save(Author customer) {
        return null;
    }

    @Override
    public Author update(Long id, Author customer) {
        return null;
    }

    @Override
    public Author delete(Long id) {
        return null;
    }
}
