package com.example.pasarela_backend.controller;

import com.example.pasarela_backend.domain.dto.InventarioDTO;

import com.example.pasarela_backend.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/obtener")
    @Operation(summary = "Obtener cantidad disponible de bolsas en el inventario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inventario obtenido correctamente"),
            @ApiResponse(responseCode = "404", description = "Inventario no encontrado")
    })
    public InventarioDTO obtenerInventario() {
        return inventarioService.obtenerInventario();
    }

    @PostMapping("/actualizar")
    @Operation(summary = "Actualizar la cantidad de bolsas en el inventario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inventario actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error en la actualización")
    })
    public InventarioDTO actualizarInventario(@RequestBody InventarioDTO inventarioDTO) {
        return inventarioService.actualizarInventario(inventarioDTO.getCantidadDisponible());
    }

    @PostMapping("/decrementar")
    @Operation(summary = "Decrementar la cantidad de bolsas en el inventario cuando se levanta una bolsa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inventario decrementado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error al decrementar inventario")
    })
    public InventarioDTO decrementarInventario(@RequestBody InventarioDTO inventarioDTO) {
        return inventarioService.decrementarInventario(inventarioDTO.getCantidadDisponible());
    }
}
