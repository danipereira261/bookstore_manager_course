package com.danielepereira.bookstoremanager.service;

import com.danielepereira.bookstoremanager.dto.BookDTO;
import com.danielepereira.bookstoremanager.dto.MessageReponseDTO;
import com.danielepereira.bookstoremanager.entity.Book;
import com.danielepereira.bookstoremanager.exception.BookNotFoundException;
import com.danielepereira.bookstoremanager.mapper.BookMapper;
import com.danielepereira.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageReponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageReponseDTO.builder()
                .message("Book created whith ID" + savedBook.getId())
                .build();

    }

    public BookDTO findById(Long id) throws BookNotFoundException {
         Book book = bookRepository.findById(id)
                 .orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }
}

