package com.example.pasarela_backend.exception;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // Este es un aspecto global que maneja excepciones en todos los controladores
public class GlobalExceptionHandler {

    // Manejo de excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleGenericException(Exception e) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                "Internal Server Error",
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return new ResponseEntity<>(errorResponse.getBody(), errorResponse.getStatusCode());
    }

    // Manejo de excepción cuando un recurso no se encuentra (por ejemplo, si el id no existe)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleNotFoundException(ResourceNotFoundException e) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                "Resource Not Found",
                e.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorResponse.getBody(), errorResponse.getStatusCode());
    }

    // Manejo de excepciones de validación de datos
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ProblemDetail> handleBadRequestException(BadRequestException e) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                "Bad Request",
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(errorResponse.getBody(), errorResponse.getStatusCode());
    }
}
