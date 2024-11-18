package com.example.pasarela_backend.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    @PostMapping("/webhook")
    public void recibirNotificacion(@RequestBody String jsonData) {
        // Procesa la notificación recibida
        System.out.println("Notificación recibida: " + jsonData);
        // Implementa la lógica para manejar la notificación
    }
}
