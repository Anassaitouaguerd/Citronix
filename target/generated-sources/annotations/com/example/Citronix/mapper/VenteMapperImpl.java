package com.example.Citronix.mapper;

import com.example.Citronix.DTO.vente.VenteDTO;
import com.example.Citronix.DTO.vente.VenteReqDTO;
import com.example.Citronix.entity.Recolte;
import com.example.Citronix.entity.Vente;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-23T20:23:55+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class VenteMapperImpl implements VenteMapper {

    @Override
    public VenteDTO toDTO(Vente vente) {
        if ( vente == null ) {
            return null;
        }

        VenteDTO venteDTO = new VenteDTO();

        venteDTO.setRecolte( venteRecolteId( vente ) );
        venteDTO.setId( vente.getId() );
        if ( vente.getDate() != null ) {
            venteDTO.setDate( DateTimeFormatter.ISO_LOCAL_DATE.format( vente.getDate() ) );
        }
        venteDTO.setUntilPrice( vente.getUntilPrice() );
        venteDTO.setClient( vente.getClient() );
        venteDTO.setRevenue( vente.getRevenue() );

        return venteDTO;
    }

    @Override
    public Vente toEntity(VenteReqDTO ventReqDTO) {
        if ( ventReqDTO == null ) {
            return null;
        }

        Vente vente = new Vente();

        vente.setDate( ventReqDTO.getDate() );
        vente.setUntilPrice( ventReqDTO.getUntilPrice() );
        vente.setClient( ventReqDTO.getClient() );

        return vente;
    }

    private Long venteRecolteId(Vente vente) {
        if ( vente == null ) {
            return null;
        }
        Recolte recolte = vente.getRecolte();
        if ( recolte == null ) {
            return null;
        }
        Long id = recolte.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
