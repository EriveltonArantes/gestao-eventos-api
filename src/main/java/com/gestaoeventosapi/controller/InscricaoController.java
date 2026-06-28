package com.gestaoeventosapi.controller;

import com.gestaoeventosapi.dto.InscricaoRequestDTO;
import com.gestaoeventosapi.dto.InscricaoResponseDTO;
import com.gestaoeventosapi.service.InscricaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Inscricao", description = "Gerenciamento de inscricaos")
@RestController
@RequestMapping("/api/inscricaos")
public class InscricaoController {

    @Autowired
    private InscricaoService service;

    @Operation(summary = "Listar todos os Inscricao")
    @GetMapping
    public List<InscricaoResponseDTO> listar(@RequestParam(required = false) String formaPagamento, @RequestParam(required = false) Long participanteId, @RequestParam(required = false) Long eventoId) {
        List<InscricaoResponseDTO> resultado = service.listar();
        if (formaPagamento != null && !formaPagamento.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getFormaPagamento() != null &&
                item.getFormaPagamento().toLowerCase().contains(formaPagamento.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (participanteId != null) {
            resultado = resultado.stream().filter(item -> participanteId.equals(item.getParticipanteId())).collect(java.util.stream.Collectors.toList());
        }
        if (eventoId != null) {
            resultado = resultado.stream().filter(item -> eventoId.equals(item.getEventoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Inscricao por ID")
    @GetMapping("/{id}")
    public InscricaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Inscricao")
    @PostMapping
    public ResponseEntity<InscricaoResponseDTO> criar(@Valid @RequestBody InscricaoRequestDTO inscricao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(inscricao));
    }

    @Operation(summary = "Atualizar Inscricao")
    @PutMapping("/{id}")
    public InscricaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody InscricaoRequestDTO inscricao) {
        return service.atualizar(id, inscricao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Inscricao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
