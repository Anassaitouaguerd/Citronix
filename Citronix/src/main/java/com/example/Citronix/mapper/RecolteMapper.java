package com.example.Citronix.mapper;

import com.example.Citronix.DTO.recolte.RecolteDTO;
import com.example.Citronix.DTO.recolte.RecolteDetailDTO;
import com.example.Citronix.DTO.recolte.RecolteReqDTO;
import com.example.Citronix.entity.Arbre;
import com.example.Citronix.entity.Champ;
import com.example.Citronix.entity.Recolte;
import com.example.Citronix.entity.RecolteDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecolteMapper {

    @Mapping(source = "champ.id", target = "champId")
    RecolteDTO toDTO(Recolte harvest);

    @Mapping(source = "champId", target = "champ")
    @Mapping(target = "recolteDetails", ignore = true)
    Recolte toEntity(RecolteReqDTO dto);

    @Mapping(source = "arbre.id", target = "arbreId")
    RecolteDetailDTO toDetailDTO(RecolteDetails detail);

    @Mapping(source = "arbreId", target = "arbre")
    RecolteDetails toDetailEntity(RecolteDetailDTO dto);

    default Champ mapChamp(Long champId) {
        if (champId == null) return null;
        return Champ.builder().id(champId).build();
    }

    default Arbre mapArbre(Long arbreId) {
        if (arbreId == null) return null;
        return Arbre.builder().id(arbreId).build();
    }

}
