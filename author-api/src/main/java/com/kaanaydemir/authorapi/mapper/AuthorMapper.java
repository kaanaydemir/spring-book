package com.kaanaydemir.authorapi.mapper;

import com.kaanaydemir.authorapi.dtos.AuthorDto;
import com.kaanaydemir.authorapi.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author convert(AuthorDto authorDto);
    AuthorDto convert(Author author);
}
