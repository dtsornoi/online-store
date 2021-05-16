package com.online.store.service;

import com.online.store.entity.Author;
import com.online.store.repository.AuthorRepository;
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
public class AuthorServiceImplementation implements AuthorService{

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findOne(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author save(Author customer) {
        return authorRepository.save(customer);
    }

    @Override
    public Author update(Long id, Author author) {
        Optional<Author> optionalAuthor = findOne(id);

        if (optionalAuthor.isPresent()){
            Author oldAuthor = optionalAuthor.get();
            oldAuthor.setFirstName(author.getFirstName());
            oldAuthor.setLastName(author.getLastName());

            return save(oldAuthor);
        }else{
            throw new RuntimeException("Author Not found");
        }
    }

    @Override
    public void delete(Long id, Author author) {
        Optional<Author> authorOptional = findOne(id);

        if (authorOptional.isPresent()){
            authorRepository.delete(author);
        }else {
            throw new RuntimeException("Author not found");
        }
    }
}
