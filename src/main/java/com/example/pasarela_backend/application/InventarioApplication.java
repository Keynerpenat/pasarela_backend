package com.example.pasarela_backend.application;

import com.example.pasarela_backend.domain.dto.InventarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.pasarela_backend.service.InventarioService;

@Component
public class InventarioApplication {

    @Autowired
    private InventarioService inventarioService;

    public InventarioDTO obtenerInventario() {
        return inventarioService.obtenerInventario();
    }

    public InventarioDTO actualizarInventario(Integer cantidad) {
        return inventarioService.actualizarInventario(cantidad);
    }

    public InventarioDTO decrementarInventario(Integer cantidad) {
        return inventarioService.decrementarInventario(cantidad);
    }
}
