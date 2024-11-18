package com.example.pasarela_backend.domain.mapper;

import com.example.pasarela_backend.domain.Inventario;
import com.example.pasarela_backend.domain.dto.InventarioDTO;


public class InventarioMapper {

    public static InventarioDTO toDTO(Inventario inventario) {
        InventarioDTO dto = new InventarioDTO();
        dto.setCantidadDisponible(inventario.getCantidadDisponible());
        return dto;
    }

    public static Inventario toEntity(InventarioDTO dto) {
        Inventario entity = new Inventario();
        entity.setCantidadDisponible(dto.getCantidadDisponible());
        return entity;
    }
}
