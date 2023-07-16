package com.example.readapi.controller;

import com.example.readapi.dtos.ReadDto;
import com.example.readapi.service.ReadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/read")
public class ReadController {
    private final ReadService readService;

    public ReadController(ReadService readService) {
        this.readService = readService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadDto> getRead(@PathVariable Long id) {
        return ResponseEntity.ok(readService.getRead(id));
    }
}
