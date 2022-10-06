package br.com.cleanarch.infra.exceptions.handlers;

import br.com.cleanarch.application.exceptions.NotFoundException;
import br.com.cleanarch.domain.exceptions.DomainException;
import br.com.cleanarch.domain.validation.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DomainException.class)
    public ResponseEntity<?> handleDomainException(final DomainException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        ValidationError validationError = new ValidationError(
                Instant.now(),
                status.value(),
                "error while validating domain",
                ex.getErrors(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(validationError);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<?> handleNotFuondException(final NotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError standardError = new StandardError(
                Instant.now(),
                status.value(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        List<Error> errors = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new Error(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        ValidationError validationError = new ValidationError(
                Instant.now(),
                status.value(),
                "error validating DTO",
                errors,
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(validationError);
    }

    record ValidationError(Instant timestamp, Integer status, String message, List<Error> errors, String path){}
    record StandardError(Instant timestamp, Integer status, String message, String path){}
}
