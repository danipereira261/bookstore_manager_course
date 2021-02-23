package com.danielepereira.bookstoremanager.service;

import com.danielepereira.bookstoremanager.dto.MessageReponseDTO;
import com.danielepereira.bookstoremanager.entity.Book;
import com.danielepereira.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageReponseDTO create(Book book) {
        Book savedBook = bookRepository.save(book);
        return MessageReponseDTO.builder()
                .message("Book created whith ID" + savedBook.getId())
                .build();

    }
}
