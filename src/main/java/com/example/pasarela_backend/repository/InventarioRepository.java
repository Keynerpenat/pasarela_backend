package com.example.pasarela_backend.repository;


import com.example.pasarela_backend.domain.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}

