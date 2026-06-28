package com.gestaoeventosapi.repository;

import com.gestaoeventosapi.model.Credenciamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredenciamentoRepository extends JpaRepository<Credenciamento, Long> {
}
