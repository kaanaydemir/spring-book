package com.kaanaydemir.bookapi.enums;

import java.util.EnumMap;
import java.util.Map;

public enum ErrorCode {
    BOOK_NOT_FOUND("Book not found ");


    private static final Map<ErrorCode,String > maps = new EnumMap<>(ErrorCode.class);

    static {
        for (ErrorCode errorCode : ErrorCode.values()) {
            maps.put(errorCode,errorCode.getMessage());
        }
    }

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessage(ErrorCode errorCode){
        return maps.get(errorCode);
    }
}
