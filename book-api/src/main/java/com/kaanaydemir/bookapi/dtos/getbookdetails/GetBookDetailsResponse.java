package com.kaanaydemir.bookapi.dtos.getbookdetails;

import com.kaanaydemir.bookapi.dtos.AuthorDto;

import java.time.LocalDate;

public record GetBookDetailsResponse(Long id,
                                     String name,
                                     Long authorId,
                                     Long genreId,
                                     Integer pageCount,
                                     LocalDate publishDate,
                                     AuthorDto author) {
}
