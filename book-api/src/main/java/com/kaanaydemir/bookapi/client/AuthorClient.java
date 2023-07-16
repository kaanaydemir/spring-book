package com.kaanaydemir.bookapi.client;

import com.kaanaydemir.bookapi.dtos.AuthorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "author-api", url = "http://localhost:8082")
public interface AuthorClient {

    @GetMapping("/api/v1/author/{id}")
    AuthorDto findById(@PathVariable Long id);
}
