package com.gestaoeventosapi.mapper;

import com.gestaoeventosapi.dto.EventoRequestDTO;
import com.gestaoeventosapi.dto.EventoResponseDTO;
import com.gestaoeventosapi.model.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    Evento toEntity(EventoRequestDTO dto);

    EventoResponseDTO toResponseDTO(Evento entity);
}
