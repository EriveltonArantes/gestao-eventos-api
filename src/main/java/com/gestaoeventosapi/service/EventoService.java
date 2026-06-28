package com.gestaoeventosapi.service;

import com.gestaoeventosapi.dto.EventoRequestDTO;
import com.gestaoeventosapi.dto.EventoResponseDTO;
import com.gestaoeventosapi.exception.ResourceNotFoundException;
import com.gestaoeventosapi.mapper.EventoMapper;
import com.gestaoeventosapi.model.Evento;
import com.gestaoeventosapi.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventoService {

    @Autowired
    private EventoRepository repository;

    @Autowired
    private EventoMapper mapper;

    @Transactional(readOnly = true)
    public List<EventoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EventoResponseDTO buscar(Long id) {
        Evento entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public EventoResponseDTO criar(EventoRequestDTO dto) {
        Evento entity = mapper.toEntity(dto);
        Evento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public EventoResponseDTO atualizar(Long id, EventoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Evento não encontrado com id: " + id);
        }
        Evento entity = mapper.toEntity(dto);
        entity.setId(id);
        Evento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Evento não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
