package com.online.store.controller;

import com.online.store.entity.Author;
import com.online.store.entity.Author;
import com.online.store.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author controller
 *
 * @author Mark Salumaa
 */

@RestController
@RequestMapping("/api/author")
public class AuthorRestController {

    private AuthorService authorService;

    @Autowired
    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> author = authorService.findAll();
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") long id) {
        Author author = authorService.findOne(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createCustomer(@RequestBody Author author){
        authorService.save(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateCustomer(@RequestBody Author author){
       authorService.update(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable("id") long id){
        authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> restoreAuthor(@PathVariable("id") long id){
        authorService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
