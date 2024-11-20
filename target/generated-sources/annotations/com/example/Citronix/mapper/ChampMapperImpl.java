package com.example.Citronix.mapper;

import com.example.Citronix.DTO.champ.ChampDTO;
import com.example.Citronix.DTO.champ.ChampReqDTO;
import com.example.Citronix.entity.Arbre;
import com.example.Citronix.entity.Champ;
import com.example.Citronix.entity.Ferme;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T21:56:38+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ChampMapperImpl implements ChampMapper {

    @Override
    public Champ toEntity(ChampDTO champDTO) {
        if ( champDTO == null ) {
            return null;
        }

        Champ champ = new Champ();

        champ.setId( champDTO.getId() );
        champ.setName( champDTO.getName() );
        champ.setArea( champDTO.getArea() );

        return champ;
    }

    @Override
    public Champ toEntity(ChampReqDTO champReqDTO) {
        if ( champReqDTO == null ) {
            return null;
        }

        Champ champ = new Champ();

        champ.setName( champReqDTO.getName() );
        champ.setArea( champReqDTO.getArea() );

        return champ;
    }

    @Override
    public ChampDTO toDTO(Champ champ) {
        if ( champ == null ) {
            return null;
        }

        ChampDTO champDTO = new ChampDTO();

        champDTO.setFerme_id( champFermeId( champ ) );
        champDTO.setId( champ.getId() );
        champDTO.setName( champ.getName() );
        champDTO.setArea( champ.getArea() );
        List<Arbre> list = champ.getArbres();
        if ( list != null ) {
            champDTO.setArbres( new ArrayList<Arbre>( list ) );
        }

        return champDTO;
    }

    private Long champFermeId(Champ champ) {
        if ( champ == null ) {
            return null;
        }
        Ferme ferme = champ.getFerme();
        if ( ferme == null ) {
            return null;
        }
        Long id = ferme.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
