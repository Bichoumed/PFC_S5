package com.mizanlabs.mr.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
class ApiError {

    private final HttpStatus status;
    private final String message;

    ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
