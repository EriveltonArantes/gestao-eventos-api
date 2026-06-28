package com.gestaoeventosapi.repository;

import com.gestaoeventosapi.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
