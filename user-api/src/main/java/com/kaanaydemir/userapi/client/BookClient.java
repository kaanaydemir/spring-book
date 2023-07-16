package com.kaanaydemir.userapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-api", url = "http://localhost:8081/api/v1/book")
public interface BookClient {

    @GetMapping("/isExist/{id}")
    Boolean isBookExist(@PathVariable Long id);
}
