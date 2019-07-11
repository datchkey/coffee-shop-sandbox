package com.coffeeshop.exception;

import com.coffeeshop.model.web.error.ErrorResponseDto;
import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public abstract ErrorResponseDto errorResponse();
    public abstract HttpStatus httpStatus();
}
