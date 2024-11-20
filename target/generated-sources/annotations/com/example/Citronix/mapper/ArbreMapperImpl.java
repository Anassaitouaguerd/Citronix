package com.example.Citronix.mapper;

import com.example.Citronix.DTO.arbre.ArbreDTO;
import com.example.Citronix.DTO.arbre.ArbreReqDTO;
import com.example.Citronix.entity.Arbre;
import com.example.Citronix.entity.Champ;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T22:21:36+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ArbreMapperImpl implements ArbreMapper {

    @Override
    public Arbre toEntity(ArbreDTO arbreDTO) {
        if ( arbreDTO == null ) {
            return null;
        }

        Arbre.ArbreBuilder arbre = Arbre.builder();

        arbre.plantationDate( arbreDTO.getPlantationDate() );
        arbre.status( arbreDTO.getStatus() );

        return arbre.build();
    }

    @Override
    public Arbre toEntity(ArbreReqDTO arbreReqDTO) {
        if ( arbreReqDTO == null ) {
            return null;
        }

        Arbre.ArbreBuilder arbre = Arbre.builder();

        arbre.plantationDate( arbreReqDTO.getPlantationDate() );
        arbre.status( arbreReqDTO.getStatus() );

        return arbre.build();
    }

    @Override
    public ArbreDTO toDTO(Arbre arbre) {
        if ( arbre == null ) {
            return null;
        }

        ArbreDTO arbreDTO = new ArbreDTO();

        arbreDTO.setChampId( arbreChampId( arbre ) );
        arbreDTO.setId( arbre.getId() );
        arbreDTO.setPlantationDate( arbre.getPlantationDate() );
        arbreDTO.setStatus( arbre.getStatus() );

        return arbreDTO;
    }

    private Long arbreChampId(Arbre arbre) {
        if ( arbre == null ) {
            return null;
        }
        Champ champ = arbre.getChamp();
        if ( champ == null ) {
            return null;
        }
        Long id = champ.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
