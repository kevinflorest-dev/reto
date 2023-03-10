package com.bcp.exchange.rate.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> handleAccessDeniedException(
            EntityNotFoundException ex, WebRequest request) {

        return handleExceptionInternal(ex, Collections.singletonMap("error", ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request);
    }

    @ExceptionHandler(value = SQLException.class)
    public ResponseEntity<Object> handleQueryException(
            SQLException ex, WebRequest request) {

        return handleExceptionInternal(ex, Collections.singletonMap("error", ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers, HttpStatus status,
                                                               WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return handleExceptionInternal(ex, Collections.singletonMap("error", errors),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }

}
