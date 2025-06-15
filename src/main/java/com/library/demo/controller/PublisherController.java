package com.library.demo.controller;

import com.library.demo.model.Publisher;
import com.library.demo.model.Book;

import com.library.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepo;

    @PostMapping
    public Publisher create(@RequestBody Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @GetMapping
    public List<Publisher> getAll() {
        return publisherRepo.findAll();
    }
    
    @GetMapping("/{id}/books")
    public List<Book> getBooksByPublisher(@PathVariable Long id) {
        Publisher publisher = publisherRepo.findById(id).orElseThrow();
        return publisher.getBooks();
    }

    @GetMapping("/{id}")
    public Publisher getById(@PathVariable Long id) {
        return publisherRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Publisher update(@PathVariable Long id, @RequestBody Publisher updated) {
        Publisher pub = publisherRepo.findById(id).orElseThrow();
        pub.setName(updated.getName());
        pub.setAddress(updated.getAddress());
        return publisherRepo.save(pub);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        publisherRepo.deleteById(id);
    }
}
