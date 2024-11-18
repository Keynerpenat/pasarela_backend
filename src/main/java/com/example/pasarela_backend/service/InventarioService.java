package com.example.pasarela_backend.service;


import com.example.pasarela_backend.domain.Inventario;
import com.example.pasarela_backend.domain.dto.InventarioDTO;
import com.example.pasarela_backend.domain.mapper.InventarioMapper;
import com.example.pasarela_backend.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public InventarioDTO obtenerInventario() {
        // Obtener el inventario actual desde la base de datos
        Inventario inventario = inventarioRepository.findById(1L).orElse(new Inventario());
        return InventarioMapper.toDTO(inventario);
    }

    public InventarioDTO actualizarInventario(Integer cantidad) {
        // Actualizar la cantidad de inventario
        Inventario inventario = inventarioRepository.findById(1L).orElse(new Inventario());
        inventario.setCantidadDisponible(cantidad);
        inventarioRepository.save(inventario);

        return InventarioMapper.toDTO(inventario);
    }

    public InventarioDTO decrementarInventario(Integer cantidad) {
        // Decrementar la cantidad disponible del inventario
        Inventario inventario = inventarioRepository.findById(1L).orElse(new Inventario());
        Integer cantidadActual = inventario.getCantidadDisponible();
        inventario.setCantidadDisponible(cantidadActual - cantidad);
        inventarioRepository.save(inventario);

        return InventarioMapper.toDTO(inventario);
    }
}
