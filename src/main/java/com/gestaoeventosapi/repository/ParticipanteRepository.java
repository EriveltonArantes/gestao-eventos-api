package com.gestaoeventosapi.repository;

import com.gestaoeventosapi.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
}
