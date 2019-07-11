package com.coffeeshop.exception;

import com.coffeeshop.model.web.error.ErrorResponseDto;
import org.springframework.http.HttpStatus;

public class GeneralApiException extends BaseException {

    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR; //500

    public GeneralApiException() {
    }

    public GeneralApiException(String message) {
        super(message);
    }

    @Override
    public ErrorResponseDto errorResponse() {
        return ErrorResponseDto.builder()
                .message(this.getMessage())
                .build();
    }

    @Override
    public HttpStatus httpStatus() {
        return DEFAULT_HTTP_STATUS;
    }
}
