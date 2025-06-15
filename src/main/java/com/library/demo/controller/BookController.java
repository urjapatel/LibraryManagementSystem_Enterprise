package com.library.demo.controller;

import com.library.demo.model.Book;
import com.library.demo.model.Publisher;

import com.library.demo.repository.BookRepository;
import com.library.demo.repository.PublisherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private PublisherRepository publisherRepo;

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookRepo.save(book);
    }
    
    @PostMapping("/publisher/{publisherId}")
    public Book createBook(@PathVariable Long publisherId, @RequestBody Book book) {
        Publisher publisher = publisherRepo.findById(publisherId).orElseThrow();
        book.setPublisher(publisher);
        return bookRepo.save(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookRepo.findById(id).orElseThrow();
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPrice(bookDetails.getPrice());
        book.setAvailable(bookDetails.isAvailable());
        return bookRepo.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepo.deleteById(id);
    }
}
