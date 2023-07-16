package com.kaanaydemir.authorapi.dtos;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private String surname;
}
