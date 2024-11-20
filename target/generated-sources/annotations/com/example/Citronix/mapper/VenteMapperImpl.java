package com.example.Citronix.mapper;

import com.example.Citronix.DTO.vente.VenteDTO;
import com.example.Citronix.DTO.vente.VenteReqDTO;
import com.example.Citronix.entity.Recolte;
import com.example.Citronix.entity.RecolteDetails;
import com.example.Citronix.entity.Vente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T21:56:39+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class VenteMapperImpl implements VenteMapper {

    @Override
    public Vente toEntity(VenteDTO venteDTO) {
        if ( venteDTO == null ) {
            return null;
        }

        Vente vente = new Vente();

        vente.setRecolte( recolteToRecolte( venteDTO.getRecolte() ) );
        vente.setId( venteDTO.getId() );
        if ( venteDTO.getDate() != null ) {
            vente.setDate( LocalDate.parse( venteDTO.getDate() ) );
        }
        vente.setClient( venteDTO.getClient() );
        if ( venteDTO.getRevenue() != null ) {
            vente.setRevenue( Double.parseDouble( venteDTO.getRevenue() ) );
        }

        return vente;
    }

    @Override
    public Vente toEntity(VenteReqDTO ventReqDTO) {
        if ( ventReqDTO == null ) {
            return null;
        }

        Vente vente = new Vente();

        vente.setDate( ventReqDTO.getDate() );
        vente.setClient( ventReqDTO.getClient() );

        return vente;
    }

    @Override
    public VenteDTO toDTO(Vente vente) {
        if ( vente == null ) {
            return null;
        }

        VenteDTO venteDTO = new VenteDTO();

        venteDTO.setId( vente.getId() );
        if ( vente.getDate() != null ) {
            venteDTO.setDate( DateTimeFormatter.ISO_LOCAL_DATE.format( vente.getDate() ) );
        }
        venteDTO.setClient( vente.getClient() );
        if ( vente.getRevenue() != null ) {
            venteDTO.setRevenue( String.valueOf( vente.getRevenue() ) );
        }
        venteDTO.setRecolte( vente.getRecolte() );

        return venteDTO;
    }

    protected Recolte recolteToRecolte(Recolte recolte) {
        if ( recolte == null ) {
            return null;
        }

        Recolte recolte1 = new Recolte();

        recolte1.setId( recolte.getId() );
        recolte1.setSeason( recolte.getSeason() );
        recolte1.setAmount( recolte.getAmount() );
        recolte1.setHarvestDate( recolte.getHarvestDate() );
        recolte1.setTotalQuantity( recolte.getTotalQuantity() );
        List<RecolteDetails> list = recolte.getRecolteDetails();
        if ( list != null ) {
            recolte1.setRecolteDetails( new ArrayList<RecolteDetails>( list ) );
        }
        List<Vente> list1 = recolte.getVents();
        if ( list1 != null ) {
            recolte1.setVents( new ArrayList<Vente>( list1 ) );
        }

        return recolte1;
    }
}
