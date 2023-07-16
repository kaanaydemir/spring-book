package com.kaanaydemir.bookapi.service;

import com.kaanaydemir.bookapi.client.AuthorClient;
import com.kaanaydemir.bookapi.dtos.AuthorDto;
import com.kaanaydemir.bookapi.dtos.getbookdetails.GetBookDetailsResponse;
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
    private final AuthorClient authorClient;

    public BookService(BookRepository bookRepository, BookMapper mapper, AuthorClient authorClient) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
        this.authorClient = authorClient;
    }

    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(mapper::convert)
                .orElseThrow(() -> new BookNotFoundException(ErrorCode.BOOK_NOT_FOUND));
    }

    public GetBookDetailsResponse getBookDetailsById(Long id) {
        BookDto book = getBookById(id);
        AuthorDto author = authorClient.findById(book.getAuthorId());
        return new GetBookDetailsResponse(book.getId(),
                book.getName(),
                book.getAuthorId(),
                book.getGenreId(),
                book.getPageCount(),
                book.getPublishDate(),
                author);
    }

    public boolean isBookExist(Long id) {
        return bookRepository.existsById(id);
    }


    public Long saveBook(BookDto bookDto) {
        return bookRepository.save(mapper.convert(bookDto)).getId();
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
