package com.kaanaydemir.bookapi.service;

import com.kaanaydemir.bookapi.exception.BookNotFoundException;
import com.kaanaydemir.bookapi.dtos.BookDto;
import com.kaanaydemir.bookapi.enums.ErrorCode;
import com.kaanaydemir.bookapi.mapper.BookMapper;
import com.kaanaydemir.bookapi.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper mapper;

    public BookService(BookRepository bookRepository, BookMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(mapper::convert)
                .orElseThrow(() -> new BookNotFoundException(ErrorCode.BOOK_NOT_FOUND));
    }

    public Long saveBook(BookDto bookDto) {
        return bookRepository.save(mapper.convert(bookDto)).getId();
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
