package com.gestaoeventosapi.mapper;

import com.gestaoeventosapi.dto.CredenciamentoRequestDTO;
import com.gestaoeventosapi.dto.CredenciamentoResponseDTO;
import com.gestaoeventosapi.model.Credenciamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CredenciamentoMapper {

    @Mapping(target = "inscricao", ignore = true)
    Credenciamento toEntity(CredenciamentoRequestDTO dto);

    @Mapping(target = "inscricaoId", source = "inscricao.id")
    CredenciamentoResponseDTO toResponseDTO(Credenciamento entity);
}
