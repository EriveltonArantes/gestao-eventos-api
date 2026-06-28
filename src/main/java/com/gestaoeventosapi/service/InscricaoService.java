package com.gestaoeventosapi.service;

import com.gestaoeventosapi.dto.InscricaoRequestDTO;
import com.gestaoeventosapi.dto.InscricaoResponseDTO;
import com.gestaoeventosapi.exception.ResourceNotFoundException;
import com.gestaoeventosapi.mapper.InscricaoMapper;
import com.gestaoeventosapi.model.Inscricao;
import com.gestaoeventosapi.repository.InscricaoRepository;
import com.gestaoeventosapi.repository.ParticipanteRepository;
import com.gestaoeventosapi.model.Participante;
import com.gestaoeventosapi.repository.EventoRepository;
import com.gestaoeventosapi.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InscricaoService {

    @Autowired
    private InscricaoRepository repository;

    @Autowired
    private InscricaoMapper mapper;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Transactional(readOnly = true)
    public List<InscricaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public InscricaoResponseDTO buscar(Long id) {
        Inscricao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Inscricao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public InscricaoResponseDTO criar(InscricaoRequestDTO dto) {
        Inscricao entity = mapper.toEntity(dto);
        Participante participante = participanteRepository.findById(dto.getParticipanteId())
            .orElseThrow(() -> new ResourceNotFoundException("Participante não encontrado com id: " + dto.getParticipanteId()));
        entity.setParticipante(participante);
        Evento evento = eventoRepository.findById(dto.getEventoId())
            .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id: " + dto.getEventoId()));
        entity.setEvento(evento);
        Inscricao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public InscricaoResponseDTO atualizar(Long id, InscricaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Inscricao não encontrado com id: " + id);
        }
        Inscricao entity = mapper.toEntity(dto);
        entity.setId(id);
        Participante participante = participanteRepository.findById(dto.getParticipanteId())
            .orElseThrow(() -> new ResourceNotFoundException("Participante não encontrado com id: " + dto.getParticipanteId()));
        entity.setParticipante(participante);
        Evento evento = eventoRepository.findById(dto.getEventoId())
            .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id: " + dto.getEventoId()));
        entity.setEvento(evento);
        Inscricao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Inscricao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
