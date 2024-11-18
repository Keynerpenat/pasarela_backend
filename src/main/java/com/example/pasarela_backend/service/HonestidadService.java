package com.example.pasarela_backend.service;

import com.example.pasarela_backend.domain.Honestidad;
import com.example.pasarela_backend.domain.dto.HonestidadDTO;
import com.example.pasarela_backend.domain.mapper.HonestidadMapper;
import com.example.pasarela_backend.repository.HonestidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HonestidadService {

    @Autowired
    private HonestidadRepository honestidadRepository;

    public HonestidadDTO procesarPago(Long userId, Boolean pagoInmediato, Double monto) {
        // Creamos la entidad
        Honestidad entity = new Honestidad();
        entity.setUserId(userId);
        entity.setPagoInmediato(pagoInmediato);
        entity.setMonto(monto);
        entity.setFechaPago(LocalDateTime.now());

        // Guardamos en la base de datos
        honestidadRepository.save(entity);

        // Convertimos la entidad a DTO y lo devolvemos
        return HonestidadMapper.toDTO(entity);
    }
}