package com.example.pasarela_backend.domain.mapper;

import com.example.pasarela_backend.domain.Honestidad;
import com.example.pasarela_backend.domain.dto.HonestidadDTO;


public class HonestidadMapper {

    public static HonestidadDTO toDTO(Honestidad honestidad) {
        HonestidadDTO dto = new HonestidadDTO();
        dto.setUserId(honestidad.getUserId());
        dto.setPagoInmediato(honestidad.getPagoInmediato());
        dto.setFechaPago(honestidad.getFechaPago());
        dto.setMonto(honestidad.getMonto());
        return dto;
    }

    public static Honestidad toEntity(HonestidadDTO dto) {
        Honestidad entity = new Honestidad();
        entity.setUserId(dto.getUserId());
        entity.setPagoInmediato(dto.getPagoInmediato());
        entity.setFechaPago(dto.getFechaPago());
        entity.setMonto(dto.getMonto());
        return entity;
    }
}
