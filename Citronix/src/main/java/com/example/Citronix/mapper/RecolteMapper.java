package com.example.Citronix.mapper;

import com.example.Citronix.DTO.recolte.RecolteDTO;
import com.example.Citronix.DTO.recolte.RecolteReqDTO;
import com.example.Citronix.entity.Recolte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecolteMapper {

    @Mapping(target = "recolteDetails", ignore = true)
    @Mapping(target = "vents", ignore = true)
    Recolte toEntity(RecolteDTO recolteDTO);

    @Mapping(target = "recolteDetails", ignore = true)
    @Mapping(target = "vents", ignore = true)
    Recolte toEntity(RecolteReqDTO recolteReqDTO);

    RecolteDTO toDTO(Recolte recolte);

}
