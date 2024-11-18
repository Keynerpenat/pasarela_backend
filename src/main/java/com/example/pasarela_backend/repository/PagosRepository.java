package com.example.pasarela_backend.repository;

import com.example.pasarela_backend.domain.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagosRepository extends JpaRepository<Pagos, Long> {
    // Métodos personalizados de búsqueda
}

