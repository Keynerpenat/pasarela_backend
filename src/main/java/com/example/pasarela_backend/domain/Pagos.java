package com.example.pasarela_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Double monto;
    private Boolean pagoCompleto;
    private LocalDateTime fechaPago;
    private String estadoPago;
    private int cantidadBolsas;  // Aquí añades el campo cantidadBolsas

}
