package com.example.pasarela_backend.application;

import com.example.pasarela_backend.domain.dto.HonestidadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.pasarela_backend.service.HonestidadService;

@Component
public class HonestidadApplication {

    @Autowired
    private HonestidadService honestidadService;

    public HonestidadDTO procesarPago(Long userId, Boolean pagoInmediato, Double monto) {
        // Aquí podrías agregar lógica adicional si es necesario
        return honestidadService.procesarPago(userId, pagoInmediato, monto);
    }
}
