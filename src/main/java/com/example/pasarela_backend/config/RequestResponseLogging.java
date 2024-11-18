package com.example.pasarela_backend.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.stereotype.Component;

@Component
public class RequestResponseLogging implements HandlerInterceptor {


    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);  // Incluye la información del cliente (IP)
        loggingFilter.setIncludeQueryString(true);  // Incluye los parámetros de la URL
        loggingFilter.setIncludePayload(true);  // Incluye el cuerpo de la solicitud
        loggingFilter.setMaxPayloadLength(10000);  // Establece la longitud máxima del cuerpo que se registrará
        loggingFilter.setAfterMessagePrefix("Request data: ");
        return loggingFilter;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Registrar la solicitud entrante
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Request Method: " + request.getMethod());
        return true;  // Continuar con el procesamiento de la solicitud
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Registrar la respuesta después de la finalización
        System.out.println("Response Status: " + response.getStatus());
    }
}
