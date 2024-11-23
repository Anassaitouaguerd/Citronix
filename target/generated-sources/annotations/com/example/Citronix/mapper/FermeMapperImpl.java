package com.example.Citronix.mapper;

import com.example.Citronix.DTO.farme.FermeDTO;
import com.example.Citronix.DTO.farme.FermeReqDTO;
import com.example.Citronix.entity.Champ;
import com.example.Citronix.entity.Ferme;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-23T20:23:55+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class FermeMapperImpl implements FermeMapper {

    @Override
    public Ferme toEntity(FermeDTO fermeDTO) {
        if ( fermeDTO == null ) {
            return null;
        }

        Ferme ferme = new Ferme();

        ferme.setId( fermeDTO.getId() );
        ferme.setName( fermeDTO.getName() );
        ferme.setLocation( fermeDTO.getLocation() );
        ferme.setArea( fermeDTO.getArea() );
        List<Champ> list = fermeDTO.getChamps();
        if ( list != null ) {
            ferme.setChamps( new ArrayList<Champ>( list ) );
        }
        ferme.setCreationDate( fermeDTO.getCreationDate() );

        return ferme;
    }

    @Override
    public Ferme toEntity(FermeReqDTO fermeReqDTO) {
        if ( fermeReqDTO == null ) {
            return null;
        }

        Ferme ferme = new Ferme();

        ferme.setName( fermeReqDTO.getName() );
        ferme.setLocation( fermeReqDTO.getLocation() );
        ferme.setArea( fermeReqDTO.getArea() );

        return ferme;
    }

    @Override
    public FermeDTO toDTO(Ferme ferme) {
        if ( ferme == null ) {
            return null;
        }

        FermeDTO fermeDTO = new FermeDTO();

        fermeDTO.setId( ferme.getId() );
        fermeDTO.setName( ferme.getName() );
        fermeDTO.setLocation( ferme.getLocation() );
        fermeDTO.setArea( ferme.getArea() );
        fermeDTO.setCreationDate( ferme.getCreationDate() );
        List<Champ> list = ferme.getChamps();
        if ( list != null ) {
            fermeDTO.setChamps( new ArrayList<Champ>( list ) );
        }

        return fermeDTO;
    }
}
