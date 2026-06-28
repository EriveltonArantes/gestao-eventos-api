package com.gestaoeventosapi.mapper;

import com.gestaoeventosapi.dto.InscricaoRequestDTO;
import com.gestaoeventosapi.dto.InscricaoResponseDTO;
import com.gestaoeventosapi.model.Inscricao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InscricaoMapper {

    @Mapping(target = "participante", ignore = true)
    @Mapping(target = "evento", ignore = true)
    Inscricao toEntity(InscricaoRequestDTO dto);

    @Mapping(target = "participanteId", source = "participante.id")
    @Mapping(target = "eventoId", source = "evento.id")
    InscricaoResponseDTO toResponseDTO(Inscricao entity);
}
