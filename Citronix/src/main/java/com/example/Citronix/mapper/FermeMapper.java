package com.example.Citronix.mapper;

import com.example.Citronix.DTO.farme.FermeDTO;
import com.example.Citronix.DTO.farme.FermeReqDTO;
import com.example.Citronix.entity.Ferme;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface FermeMapper {

    Ferme toEntity(FermeDTO fermeDTO);

    @Mapping(target = "champs", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    Ferme toEntity(FermeReqDTO fermeReqDTO);

    FermeDTO toDTO(Ferme ferme);
}
