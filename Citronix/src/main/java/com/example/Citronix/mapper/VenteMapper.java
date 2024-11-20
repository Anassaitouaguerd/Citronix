package com.example.Citronix.mapper;

import com.example.Citronix.DTO.vente.VenteReqDTO;
import com.example.Citronix.DTO.vente.VenteDTO;
import com.example.Citronix.entity.Vente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VenteMapper {

    @Mapping(target = "recolte" , ignore = true)
    @Mapping(target = "recolte.id" , source = "recolte.id")
    Vente toEntity(VenteDTO venteDTO);

    @Mapping(target = "recolte" , ignore = true)
    @Mapping(target = "id" , ignore = true)
    Vente toEntity(VenteReqDTO ventReqDTO);

    VenteDTO toDTO(Vente vente);

}
