package com.kaanaydemir.authorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorApiApplication.class, args);
    }

}
