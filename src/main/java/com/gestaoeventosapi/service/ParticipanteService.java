package com.gestaoeventosapi.service;

import com.gestaoeventosapi.dto.ParticipanteRequestDTO;
import com.gestaoeventosapi.dto.ParticipanteResponseDTO;
import com.gestaoeventosapi.exception.ResourceNotFoundException;
import com.gestaoeventosapi.mapper.ParticipanteMapper;
import com.gestaoeventosapi.model.Participante;
import com.gestaoeventosapi.repository.ParticipanteRepository;
import com.gestaoeventosapi.repository.EventoRepository;
import com.gestaoeventosapi.model.Evento;
import com.gestaoeventosapi.repository.CredenciamentoRepository;
import com.gestaoeventosapi.model.Credenciamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository repository;

    @Autowired
    private ParticipanteMapper mapper;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private CredenciamentoRepository credenciamentoRepository;

    @Transactional(readOnly = true)
    public List<ParticipanteResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ParticipanteResponseDTO buscar(Long id) {
        Participante entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Participante não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ParticipanteResponseDTO criar(ParticipanteRequestDTO dto) {
        Participante entity = mapper.toEntity(dto);
        Evento evento = eventoRepository.findById(dto.getEventoId())
            .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id: " + dto.getEventoId()));
        entity.setEvento(evento);
        Credenciamento credenciamento = credenciamentoRepository.findById(dto.getCredenciamentoId())
            .orElseThrow(() -> new ResourceNotFoundException("Credenciamento não encontrado com id: " + dto.getCredenciamentoId()));
        entity.setCredenciamento(credenciamento);
        Participante salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ParticipanteResponseDTO atualizar(Long id, ParticipanteRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Participante não encontrado com id: " + id);
        }
        Participante entity = mapper.toEntity(dto);
        entity.setId(id);
        Evento evento = eventoRepository.findById(dto.getEventoId())
            .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id: " + dto.getEventoId()));
        entity.setEvento(evento);
        Credenciamento credenciamento = credenciamentoRepository.findById(dto.getCredenciamentoId())
            .orElseThrow(() -> new ResourceNotFoundException("Credenciamento não encontrado com id: " + dto.getCredenciamentoId()));
        entity.setCredenciamento(credenciamento);
        Participante salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Participante não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
