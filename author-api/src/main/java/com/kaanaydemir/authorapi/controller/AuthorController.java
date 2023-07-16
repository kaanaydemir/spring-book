package com.kaanaydemir.authorapi.controller;

import com.kaanaydemir.authorapi.dtos.AuthorDto;
import com.kaanaydemir.authorapi.service.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public AuthorDto findById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        authorService.deleteById(id);
    }

    @GetMapping("/deleteAll")
    public void deleteAll() {
        authorService.deleteAll();
    }

    @PostMapping("/save")
    public AuthorDto save(@RequestBody AuthorDto authorDto) {
        return authorService.save(authorDto);
    }
}
