    package com.example.pasarela_backend.exception;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.Getter;
    import lombok.Setter;


    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    public class ErrorResponse {
        private String error;
        private String message;
    }
