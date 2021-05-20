package com.online.store.controller;

import com.online.store.entity.Author;
import com.online.store.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for Author.Class
 * URI:<code>/api/user-account</code>
 *
 * @author Mark Salumaa
 */

@RestController
@RequestMapping("/api/author")
@CrossOrigin(origins = "*")
public class AuthorRestController {

    private final AuthorService authorService;

    @Autowired
    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * GET:<code>/</code>
     * @return All Authors
     */
    @GetMapping("/")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> author = authorService.findAll();
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    /**
     * GET:<code>/id</code>
     * @param id of type Long for searching Author by Id in DB
     * @return Author with specified Id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") Long id) {
        Author author = authorService.findOne(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    /**
     * POST:<code>/</code>
     * @param author from UI to be persisted to DB
     * @return HttpStatus 201
     */
    @PostMapping("/")
    public ResponseEntity<HttpStatus> createCustomer(@RequestBody Author author){
        authorService.save(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * PUT:<code>/</code>
     * @param author from UI to be updated in DB
     * @return HttpStatus 200
     */
    @PutMapping("/")
    public ResponseEntity<HttpStatus> updateCustomer(@RequestBody Author author){
       authorService.update(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/delete/id</code>
     * @param id of type Long for searching Author which to delete by id
     * @return HttpStatus 200
     */
    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable("id") Long id){
        authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/restore/id</code>
     * @param id of type Long for searching Author which to restore by ID
     * @return HttpStatus 200
     */
    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> restoreAuthor(@PathVariable("id") Long id){
        authorService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
