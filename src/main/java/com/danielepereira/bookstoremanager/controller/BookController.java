package com.danielepereira.bookstoremanager.controller;


import com.danielepereira.bookstoremanager.dto.BookDTO;
import com.danielepereira.bookstoremanager.dto.MessageReponseDTO;
import com.danielepereira.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageReponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findByID(@PathVariable Long id) {
        return bookService.findById(id);
    }
}
