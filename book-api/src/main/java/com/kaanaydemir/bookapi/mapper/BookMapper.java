package com.kaanaydemir.bookapi.mapper;

import com.kaanaydemir.bookapi.dtos.BookDto;
import com.kaanaydemir.bookapi.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto convert(Book entity);
    Book convert(BookDto dto);

}
