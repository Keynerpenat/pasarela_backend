package com.example.pasarela_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class PagoSimuladoController {

    private final Esp32Notifier esp32Notifier; // Inyecta Esp32Notifier

    /**
     * Endpoint para simular el pago.
     *
     * @param monto Monto del pago simulado.
     * @return Respuesta del backend indicando el estado del pago.
     */
    @GetMapping("/api/pago/simular")
    public String simularPago(@RequestParam double monto) {
        System.out.println("Simulando pago por el monto: " + monto);

        try {
            // Verificar si la ESP32 está conectada
            if (esp32Notifier.verificarConexionESP32()) {
                // Si la ESP32 está conectada, notificarla
                esp32Notifier.notificarESP32();

                // Respuesta exitosa
                return "Pago simulado de $" + monto + " exitoso. Notificación enviada a ESP32.";
            } else {
                // Si la ESP32 no está conectada, devolver error
                return "Error: La ESP32 no está disponible. No se puede procesar el pago.";
            }
        } catch (Exception e) {
            // Manejo de errores
            System.err.println("Error al simular pago: " + e.getMessage());
            return "Error al simular pago: " + e.getMessage();
        }
    }
}
