package com.example.pasarela_backend.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PagosDTO {
    private Long userId;
    private Double monto;
    private Boolean pagoCompleto;
    private LocalDateTime fechaPago;  // Asegúrate de incluir este campo
    private String estadoPago;
    private int cantidadBolsas;  // Aquí añades el campo cantidadBolsas
}
