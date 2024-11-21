package com.example.Citronix.mapper;

import com.example.Citronix.DTO.champ.ChampDTO;
import com.example.Citronix.DTO.champ.ChampReqDTO;
import com.example.Citronix.entity.Champ;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChampMapper {

    @Mapping(target = "arbres", ignore = true)
    @Mapping(target = "ferme", ignore = true)
    Champ toEntity(ChampDTO champDTO);

    @Mapping(target = "ferme", ignore = true)
    @Mapping(target = "arbres", ignore = true)
    Champ toEntity(ChampReqDTO champReqDTO);

    @Mapping(target = "ferme_id" , source = "ferme.id")
    ChampDTO toDTO(Champ champ);

}
