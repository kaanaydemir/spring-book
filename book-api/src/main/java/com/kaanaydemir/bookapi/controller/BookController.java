package com.kaanaydemir.bookapi.controller;

import com.kaanaydemir.bookapi.dtos.BookDto;
import com.kaanaydemir.bookapi.dtos.getbookdetails.GetBookDetailsResponse;
import com.kaanaydemir.bookapi.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Long> saveBook(@RequestBody BookDto book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<GetBookDetailsResponse> getBookDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookDetailsById(id));
    }
}
