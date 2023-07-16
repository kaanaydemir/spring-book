package com.example.readapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class ReadDto {

    private Long userId;
    private Set<Long> books;
}
