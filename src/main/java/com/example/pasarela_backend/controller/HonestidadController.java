package com.example.pasarela_backend.controller;


import com.example.pasarela_backend.domain.dto.HonestidadDTO;
import com.example.pasarela_backend.service.HonestidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/honestidad")
public class HonestidadController {

    @Autowired
    private HonestidadService honestidadService;

    @PostMapping("/procesar")
    public HonestidadDTO procesarPago(@RequestBody HonestidadDTO honestidadDTO) {
        return honestidadService.procesarPago(honestidadDTO.getUserId(), honestidadDTO.getPagoInmediato(), honestidadDTO.getMonto());
    }
}
