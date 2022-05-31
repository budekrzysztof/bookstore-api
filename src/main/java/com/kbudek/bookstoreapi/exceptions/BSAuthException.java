package com.kbudek.bookstoreapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BSAuthException extends RuntimeException {

    public BSAuthException(String message) {
        super(message);
    }
}
