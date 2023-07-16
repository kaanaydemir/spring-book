package com.example.readapi.service;

import com.example.readapi.dtos.ReadDto;
import com.example.readapi.entity.Read;
import com.example.readapi.mapper.ReadMapper;
import com.example.readapi.repository.ReadRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReadService {
    private final ReadRepository readRepository;
    private final ReadMapper readMapper;

    public ReadDto getRead(Long userId) {
        return readRepository.findById(userId)
                .map(readMapper::convert)
                .orElseThrow(() -> new RuntimeException("User hasn't any read"));
    }
    public ReadService(ReadRepository readRepository, ReadMapper readMapper) {
        this.readRepository = readRepository;
        this.readMapper = readMapper;
    }

    public void createRead(Long userId, Long bookId) {
        readRepository.findById(userId).ifPresentOrElse(read ->
        {
            read.getBooks().add(bookId);
            readRepository.save(read);
        },
                () -> readRepository.save(new Read(userId, Set.of(bookId)))
        );
    }
}
