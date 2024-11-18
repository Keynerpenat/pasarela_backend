package com.example.pasarela_backend.controller;

import com.example.pasarela_backend.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/pagos")  // Este es el prefijo para la URL
@CrossOrigin(origins = "http://127.0.0.1:5500/")  // Asegúrate de permitir solicitudes desde tu frontend
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping("/procesar")  // Este es el endpoint que debes usar en tu fetch
    public ResponseEntity<Map<String, String>> crearPreferencia(@RequestBody Map<String, Object> request) {
        int cantidadBolsas = (Integer) request.get("cantidadBolsas");

        if (cantidadBolsas <= 0) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "La cantidad de bolsas debe ser mayor a cero.");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        String initPoint;
        try {
            initPoint = pagoService.crearPreferencia(cantidadBolsas);
            Map<String, String> response = new HashMap<>();
            response.put("init_point", initPoint);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Hubo un error al crear la preferencia de pago.");
            errorResponse.put("details", e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
}
