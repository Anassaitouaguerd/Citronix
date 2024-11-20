package com.example.Citronix.mapper;

import com.example.Citronix.DTO.arbre.ArbreDTO;
import com.example.Citronix.DTO.arbre.ArbreReqDTO;
import com.example.Citronix.entity.Arbre;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ArbreMapper {

    @Mapping(target = "champ", ignore = true)
    @Mapping(target = "recolteDetails", ignore = true)
    @Mapping(target = "id", ignore = true)
    Arbre toEntity(ArbreDTO arbreDTO);

    @Mapping(target = "champ", ignore = true)
    @Mapping(target = "recolteDetails", ignore = true)
    @Mapping(target = "id", ignore = true)
    Arbre toEntity(ArbreReqDTO arbreReqDTO);

    @Mapping(source = "champ.id", target = "champId")
    ArbreDTO toDTO(Arbre arbre);
}
