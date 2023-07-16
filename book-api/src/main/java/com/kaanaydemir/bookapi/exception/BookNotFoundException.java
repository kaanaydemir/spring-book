package com.kaanaydemir.bookapi.exception;

import com.kaanaydemir.bookapi.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(ErrorCode errorCode) {
        super(ErrorCode.getMessage(errorCode));
    }
}
