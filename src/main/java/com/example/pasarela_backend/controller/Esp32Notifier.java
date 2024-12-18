package com.example.pasarela_backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class Esp32Notifier {

    private static final Logger logger = LoggerFactory.getLogger(Esp32Notifier.class);
    private static final String ESP32_URL = "http://192.168.40.120/api/pago-confirmado";  // URL de la ESP32

    // Método para verificar si la ESP32 está conectada
    public boolean verificarConexionESP32() {
        try {
            URL url = new URL(ESP32_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();
            // Si el código de respuesta es HTTP_OK (200), la ESP32 está disponible
            if (responseCode == HttpURLConnection.HTTP_OK) {
                logger.info("Conexión exitosa con la ESP32.");
                return true;
            } else {
                logger.error("Error al conectar con la ESP32. Código de respuesta: " + responseCode);
                return false;
            }
        } catch (Exception e) {
            logger.error("Error al verificar la conexión con la ESP32: ", e);
            return false;
        }
    }

    // Método para notificar a la ESP32 que el pago fue confirmado
    public void notificarESP32() {
        try {
            URL url = new URL(ESP32_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                logger.info("Respuesta de ESP32: " + response.toString());
            } else {
                logger.error("Error al notificar a la ESP32. Código de respuesta: " + responseCode);
            }
        } catch (Exception e) {
            logger.error("Error al enviar notificación a la ESP32: ", e);
        }
    }
}
