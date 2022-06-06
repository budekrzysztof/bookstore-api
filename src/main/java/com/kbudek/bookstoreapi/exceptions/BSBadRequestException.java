package com.kbudek.bookstoreapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BSBadRequestException extends RuntimeException {
    public BSBadRequestException(String message) {
        super(message);
    }
}
