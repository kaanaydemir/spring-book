package com.kaanaydemir.bookapi.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDto {

    private Long id;
    private String name;
    private Long authorId;
    private Long genreId;
    private Integer pageCount;
    private LocalDate publishDate;
}
