package com.mk.demonce.Controller;


import com.mk.demonce.model.Book;
import com.mk.demonce.repo.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value={"/api"},produces ="application/json" )
public class RestHomeController {


    public RestHomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private BookRepository bookRepository;


    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id) {
        Optional<Book> bookMaybe = bookRepository.findById(id);
        if (bookMaybe.isPresent()) {
          return  new ResponseEntity<>(bookMaybe.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);


    }
    @PostMapping(consumes = "application/json")
    public Book postBook(@RequestBody Book book){
        return bookRepository.save(book);
    }
}