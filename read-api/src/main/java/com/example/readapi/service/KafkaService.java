package com.example.readapi.service;

import com.example.readapi.dtos.KafkaReadDto;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private final ReadService readService;

    public KafkaService(ReadService readService) {
        this.readService = readService;
    }

    public void consume(String message) {
        Gson gson = new Gson();
        KafkaReadDto readDto = gson.fromJson(message, KafkaReadDto.class);
        readService.createRead(readDto.userId(), readDto.bookId());

    }
}
