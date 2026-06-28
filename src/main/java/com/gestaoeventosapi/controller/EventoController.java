package com.gestaoeventosapi.controller;

import com.gestaoeventosapi.dto.EventoRequestDTO;
import com.gestaoeventosapi.dto.EventoResponseDTO;
import com.gestaoeventosapi.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Evento", description = "Gerenciamento de eventos")
@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @Operation(summary = "Listar todos os Evento")
    @GetMapping
    public List<EventoResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<EventoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Evento por ID")
    @GetMapping("/{id}")
    public EventoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Evento")
    @PostMapping
    public ResponseEntity<EventoResponseDTO> criar(@Valid @RequestBody EventoRequestDTO evento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(evento));
    }

    @Operation(summary = "Atualizar Evento")
    @PutMapping("/{id}")
    public EventoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody EventoRequestDTO evento) {
        return service.atualizar(id, evento);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Evento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
