package com.gestaoeventosapi.repository;

import com.gestaoeventosapi.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}
