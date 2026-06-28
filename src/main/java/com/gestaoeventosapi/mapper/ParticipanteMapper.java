package com.gestaoeventosapi.mapper;

import com.gestaoeventosapi.dto.ParticipanteRequestDTO;
import com.gestaoeventosapi.dto.ParticipanteResponseDTO;
import com.gestaoeventosapi.model.Participante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParticipanteMapper {

    @Mapping(target = "evento", ignore = true)
    @Mapping(target = "credenciamento", ignore = true)
    Participante toEntity(ParticipanteRequestDTO dto);

    @Mapping(target = "eventoId", source = "evento.id")
    @Mapping(target = "credenciamentoId", source = "credenciamento.id")
    ParticipanteResponseDTO toResponseDTO(Participante entity);
}
