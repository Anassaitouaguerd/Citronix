package com.example.Citronix.mapper;

import com.example.Citronix.DTO.recolte.RecolteDTO;
import com.example.Citronix.DTO.recolte.RecolteDetailDTO;
import com.example.Citronix.entity.Recolte;
import com.example.Citronix.entity.RecolteDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecolteMapper {

    @Mapping(source = "champ.id", target = "champId")
    RecolteDTO toDTO(Recolte harvest);

//    @Mapping(source = "champId", target = "champ")
    @Mapping(target = "recolteDetails", ignore = true)
    Recolte toEntity(RecolteDTO dto);

    @Mapping(source = "arbre.id", target = "arbreId")
    RecolteDetailDTO toDetailDTO(RecolteDetails detail);

//    @Mapping(source = "arbreId", target = "arbre")
    RecolteDetails toDetailEntity(RecolteDetailDTO dto);

}
