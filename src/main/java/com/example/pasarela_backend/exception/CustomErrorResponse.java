package com.example.pasarela_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.HttpHeaders;

public class CustomErrorResponse {

    private final String error;
    private final String message;
    private final HttpStatus statusCode;

    // Constructor
    public CustomErrorResponse(String error, String message, HttpStatus statusCode) {
        this.error = error;
        this.message = message;
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public ProblemDetail getBody() {
        // Creamos el ProblemDetail con la información de error
        ProblemDetail problemDetail = ProblemDetail.forStatus(statusCode);
        problemDetail.setTitle(error);  // Título del error
        problemDetail.setDetail(message);  // Detalle del mensaje
        return problemDetail;
    }

    public HttpHeaders getHeaders() {
        return new HttpHeaders();  // Puedes añadir más headers si es necesario
    }
}
