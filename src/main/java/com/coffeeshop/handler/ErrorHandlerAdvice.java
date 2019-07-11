package com.coffeeshop.handler;

import com.coffeeshop.exception.BaseException;
import com.coffeeshop.model.web.error.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@ControllerAdvice
public class ErrorHandlerAdvice {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> getResponse(Exception e) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .message(e.getMessage())
                .build();

        return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponseDto> getResponse(ResponseStatusException e) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .message(e.getMessage())
                .build();

        log.error("Input validation error: {} ", errorResponseDto);
        return new ResponseEntity<ErrorResponseDto>(errorResponseDto, e.getStatus());

    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponseDto> getResponse(BaseException e) {
        return new ResponseEntity<ErrorResponseDto>(e.errorResponse(), e.httpStatus());
    }
}
