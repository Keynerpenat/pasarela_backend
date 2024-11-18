package com.example.pasarela_backend.domain.mapper;

import com.example.pasarela_backend.domain.Pagos;
import com.example.pasarela_backend.domain.dto.PagosDTO;


public class PagosMapper {

    public static PagosDTO toDTO(Pagos pagos) {
        PagosDTO dto = new PagosDTO();
        dto.setUserId(pagos.getUserId());
        dto.setMonto(pagos.getMonto());
        dto.setPagoCompleto(pagos.getPagoCompleto());
        dto.setFechaPago(pagos.getFechaPago());
        dto.setEstadoPago(pagos.getEstadoPago());
        return dto;
    }

    public static Pagos toEntity(PagosDTO dto) {
        Pagos entity = new Pagos();
        entity.setUserId(dto.getUserId());
        entity.setMonto(dto.getMonto());
        entity.setPagoCompleto(dto.getPagoCompleto());
        entity.setFechaPago(dto.getFechaPago());
        entity.setEstadoPago(dto.getEstadoPago());
        return entity;
    }
}
