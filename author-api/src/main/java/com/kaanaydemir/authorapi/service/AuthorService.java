package com.kaanaydemir.authorapi.service;

import com.kaanaydemir.authorapi.dtos.AuthorDto;
import com.kaanaydemir.authorapi.mapper.AuthorMapper;
import com.kaanaydemir.authorapi.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    public void deleteAll() {
        authorRepository.deleteAll();
    }

    public AuthorDto save(AuthorDto authorDto) {
        return authorMapper.convert(authorRepository.save(authorMapper.convert(authorDto)));
    }

    public AuthorDto findById(Long id) {
        return authorMapper.convert(authorRepository.findById(id).orElse(null));
    }

    public AuthorDto update(AuthorDto authorDto) {
        return authorMapper.convert(authorRepository.save(authorMapper.convert(authorDto)));
    }

    

}
