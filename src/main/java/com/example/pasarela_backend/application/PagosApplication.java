package com.example.pasarela_backend.application;

import com.example.pasarela_backend.domain.dto.PagosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.pasarela_backend.service.PagoService;

@Component
public class PagosApplication {

    @Autowired
    private PagoService pagosService;

    public PagosDTO procesarPago(Long userId, Double monto, Boolean pagoCompleto) {
        return pagosService.procesarPago(userId, monto, pagoCompleto);
    }
}
