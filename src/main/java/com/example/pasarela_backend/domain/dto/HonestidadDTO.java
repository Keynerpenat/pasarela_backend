package com.example.pasarela_backend.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class HonestidadDTO {
    private Long userId;
    private Boolean pagoInmediato;
    private LocalDateTime fechaPago;
    private Double monto;
}
