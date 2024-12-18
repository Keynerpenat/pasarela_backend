package com.example.pasarela_backend.service.sms;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {

    private static final String SMS_API_URL = "https://cuervo.cvrelectronica.com/sendSms/toContact/";

    public void enviarMensaje(String phoneNumber, String message) {
        // Configura RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Crear el cuerpo de la solicitud utilizando MultiValueMap
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("contact", phoneNumber);
        body.add("message", message);

        // Crear las cabeceras de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Crear la solicitud HTTP con los parámetros y las cabeceras
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        // Enviar la solicitud POST a la API usando RestTemplate
        try {
            restTemplate.exchange(SMS_API_URL, HttpMethod.POST, request, String.class);
            System.out.println("Mensaje enviado con éxito a " + phoneNumber);
        } catch (Exception e) {
            System.err.println("Error al enviar el mensaje: " + e.getMessage());
        }
    }
}
