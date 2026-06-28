package com.gestaoeventosapi.controller;

import com.gestaoeventosapi.dto.ParticipanteRequestDTO;
import com.gestaoeventosapi.dto.ParticipanteResponseDTO;
import com.gestaoeventosapi.service.ParticipanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Participante", description = "Gerenciamento de participantes")
@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService service;

    @Operation(summary = "Listar todos os Participante")
    @GetMapping
    public List<ParticipanteResponseDTO> listar(@RequestParam(required = false) String nome, @RequestParam(required = false) Long eventoId, @RequestParam(required = false) Long credenciamentoId) {
        List<ParticipanteResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (eventoId != null) {
            resultado = resultado.stream().filter(item -> eventoId.equals(item.getEventoId())).collect(java.util.stream.Collectors.toList());
        }
        if (credenciamentoId != null) {
            resultado = resultado.stream().filter(item -> credenciamentoId.equals(item.getCredenciamentoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Participante por ID")
    @GetMapping("/{id}")
    public ParticipanteResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Participante")
    @PostMapping
    public ResponseEntity<ParticipanteResponseDTO> criar(@Valid @RequestBody ParticipanteRequestDTO participante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(participante));
    }

    @Operation(summary = "Atualizar Participante")
    @PutMapping("/{id}")
    public ParticipanteResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ParticipanteRequestDTO participante) {
        return service.atualizar(id, participante);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Participante")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
