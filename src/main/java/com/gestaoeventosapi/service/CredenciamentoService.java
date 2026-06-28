package com.gestaoeventosapi.service;

import com.gestaoeventosapi.dto.CredenciamentoRequestDTO;
import com.gestaoeventosapi.dto.CredenciamentoResponseDTO;
import com.gestaoeventosapi.exception.ResourceNotFoundException;
import com.gestaoeventosapi.mapper.CredenciamentoMapper;
import com.gestaoeventosapi.model.Credenciamento;
import com.gestaoeventosapi.repository.CredenciamentoRepository;
import com.gestaoeventosapi.repository.InscricaoRepository;
import com.gestaoeventosapi.model.Inscricao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CredenciamentoService {

    @Autowired
    private CredenciamentoRepository repository;

    @Autowired
    private CredenciamentoMapper mapper;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Transactional(readOnly = true)
    public List<CredenciamentoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CredenciamentoResponseDTO buscar(Long id) {
        Credenciamento entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Credenciamento não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CredenciamentoResponseDTO criar(CredenciamentoRequestDTO dto) {
        Credenciamento entity = mapper.toEntity(dto);
        Inscricao inscricao = inscricaoRepository.findById(dto.getInscricaoId())
            .orElseThrow(() -> new ResourceNotFoundException("Inscricao não encontrado com id: " + dto.getInscricaoId()));
        entity.setInscricao(inscricao);
        Credenciamento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CredenciamentoResponseDTO atualizar(Long id, CredenciamentoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Credenciamento não encontrado com id: " + id);
        }
        Credenciamento entity = mapper.toEntity(dto);
        entity.setId(id);
        Inscricao inscricao = inscricaoRepository.findById(dto.getInscricaoId())
            .orElseThrow(() -> new ResourceNotFoundException("Inscricao não encontrado com id: " + dto.getInscricaoId()));
        entity.setInscricao(inscricao);
        Credenciamento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Credenciamento não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
