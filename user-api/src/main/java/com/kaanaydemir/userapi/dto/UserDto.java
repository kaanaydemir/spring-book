package com.kaanaydemir.userapi.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
}
