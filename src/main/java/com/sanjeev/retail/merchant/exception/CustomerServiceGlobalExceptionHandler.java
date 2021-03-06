package com.sanjeev.retail.merchant.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

@RestControllerAdvice
public class CustomerServiceGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ApiErrorResponse>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Set<ApiErrorResponse> errors = new HashSet<>();
        ex.getBindingResult()
                .getAllErrors()
                .forEach(objectError -> {
                    FieldError fieldError = (FieldError) objectError;
                    errors.add(this.createApiErrorResponseForFieldValidations(fieldError));
                });
        return new ResponseEntity<>(new ArrayList<>(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DuplicateKeyException.class})
    public ResponseEntity<ApiErrorResponse> handleDuplicateKeyException(DuplicateKeyException ex) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .errorMessage(ex.getMessage())
                .context(ex.getMessage())
                .timestamp(OffsetDateTime.now(ZoneOffset.UTC))
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ApiErrorResponse> handleValidationRuntimeException(RuntimeException ex) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .errorMessage(ex.getMessage())
                .context(ex.getMessage())
                .timestamp(OffsetDateTime.now(ZoneOffset.UTC))
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ApiErrorResponse createApiErrorResponseForFieldValidations(FieldError fieldError) {
        return ApiErrorResponse.builder()
                .errorMessage(fieldError.getDefaultMessage())
                .context(fieldError.getObjectName() + "." + fieldError.getField() + " : rejected value: " + fieldError.getRejectedValue())
                .timestamp(OffsetDateTime.now(ZoneOffset.UTC))
                .build();
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<Map<String, String>> constraintViolationException(ConstraintViolationException ex) {
        HashMap<String, String> errors = new HashMap<>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        violations.forEach(constraintViolation ->
                errors.put((String) constraintViolation.getInvalidValue(), constraintViolation.getMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
