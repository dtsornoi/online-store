package com.online.store.service.implementation;

import com.online.store.entity.Author;
import com.online.store.repository.AuthorRepository;
import com.online.store.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * AuthorService Implementation
 *
 * @author Dmitri Tsornoi
 */

@Service
public class AuthorServiceImplementation implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findOne(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public void save(Author customer) {
        authorRepository.saveAndFlush(customer);
    }

    @Override
    public void update(Author author) {
        Author oldAuthor = findOne(author.getId());
        oldAuthor.setFirstName(author.getFirstName());
        oldAuthor.setLastName(author.getLastName());

        save(oldAuthor);
    }

    @Override
    public void delete(Long id) {
        Author author = findOne(id);
        author.setActive(false);
        save(author);
    }

    @Override
    public void restore(Long id){
        Author author = findOne(id);
        author.setActive(true);
        save(author);
    }
}
