package com.gestaoeventosapi.controller;

import com.gestaoeventosapi.dto.CredenciamentoRequestDTO;
import com.gestaoeventosapi.dto.CredenciamentoResponseDTO;
import com.gestaoeventosapi.service.CredenciamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Credenciamento", description = "Gerenciamento de credenciamentos")
@RestController
@RequestMapping("/api/credenciamentos")
public class CredenciamentoController {

    @Autowired
    private CredenciamentoService service;

    @Operation(summary = "Listar todos os Credenciamento")
    @GetMapping
    public List<CredenciamentoResponseDTO> listar(@RequestParam(required = false) String cracha, @RequestParam(required = false) Long inscricaoId) {
        List<CredenciamentoResponseDTO> resultado = service.listar();
        if (cracha != null && !cracha.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getCracha() != null &&
                item.getCracha().toLowerCase().contains(cracha.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (inscricaoId != null) {
            resultado = resultado.stream().filter(item -> inscricaoId.equals(item.getInscricaoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Credenciamento por ID")
    @GetMapping("/{id}")
    public CredenciamentoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Credenciamento")
    @PostMapping
    public ResponseEntity<CredenciamentoResponseDTO> criar(@Valid @RequestBody CredenciamentoRequestDTO credenciamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(credenciamento));
    }

    @Operation(summary = "Atualizar Credenciamento")
    @PutMapping("/{id}")
    public CredenciamentoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CredenciamentoRequestDTO credenciamento) {
        return service.atualizar(id, credenciamento);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Credenciamento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
