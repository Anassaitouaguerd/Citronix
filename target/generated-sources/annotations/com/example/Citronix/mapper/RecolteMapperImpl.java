package com.example.Citronix.mapper;

import com.example.Citronix.DTO.recolte.RecolteDTO;
import com.example.Citronix.DTO.recolte.RecolteDetailDTO;
import com.example.Citronix.DTO.vente.VenteDTO;
import com.example.Citronix.entity.Arbre;
import com.example.Citronix.entity.Champ;
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
    date = "2024-11-22T09:42:32+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class RecolteMapperImpl implements RecolteMapper {

    @Override
    public RecolteDTO toDTO(Recolte harvest) {
        if ( harvest == null ) {
            return null;
        }

        RecolteDTO recolteDTO = new RecolteDTO();

        recolteDTO.setChampId( harvestChampId( harvest ) );
        recolteDTO.setId( harvest.getId() );
        recolteDTO.setSeason( harvest.getSeason() );
        recolteDTO.setTotalQuantity( harvest.getTotalQuantity() );
        recolteDTO.setRecolteDate( harvest.getRecolteDate() );
        recolteDTO.setVents( venteListToVenteDTOList( harvest.getVents() ) );

        return recolteDTO;
    }

    @Override
    public Recolte toEntity(RecolteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Recolte recolte = new Recolte();

        recolte.setId( dto.getId() );
        recolte.setSeason( dto.getSeason() );
        recolte.setRecolteDate( dto.getRecolteDate() );
        recolte.setTotalQuantity( dto.getTotalQuantity() );
        recolte.setVents( venteDTOListToVenteList( dto.getVents() ) );

        return recolte;
    }

    @Override
    public RecolteDetailDTO toDetailDTO(RecolteDetails detail) {
        if ( detail == null ) {
            return null;
        }

        RecolteDetailDTO.RecolteDetailDTOBuilder recolteDetailDTO = RecolteDetailDTO.builder();

        recolteDetailDTO.arbreId( detailArbreId( detail ) );
        recolteDetailDTO.id( detail.getId() );
        recolteDetailDTO.quantity( detail.getQuantity() );

        return recolteDetailDTO.build();
    }

    @Override
    public RecolteDetails toDetailEntity(RecolteDetailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RecolteDetails recolteDetails = new RecolteDetails();

        recolteDetails.setId( dto.getId() );
        recolteDetails.setQuantity( dto.getQuantity() );

        return recolteDetails;
    }

    private Long harvestChampId(Recolte recolte) {
        if ( recolte == null ) {
            return null;
        }
        Champ champ = recolte.getChamp();
        if ( champ == null ) {
            return null;
        }
        Long id = champ.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected VenteDTO venteToVenteDTO(Vente vente) {
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

    protected List<VenteDTO> venteListToVenteDTOList(List<Vente> list) {
        if ( list == null ) {
            return null;
        }

        List<VenteDTO> list1 = new ArrayList<VenteDTO>( list.size() );
        for ( Vente vente : list ) {
            list1.add( venteToVenteDTO( vente ) );
        }

        return list1;
    }

    protected Vente venteDTOToVente(VenteDTO venteDTO) {
        if ( venteDTO == null ) {
            return null;
        }

        Vente vente = new Vente();

        vente.setId( venteDTO.getId() );
        if ( venteDTO.getDate() != null ) {
            vente.setDate( LocalDate.parse( venteDTO.getDate() ) );
        }
        vente.setClient( venteDTO.getClient() );
        if ( venteDTO.getRevenue() != null ) {
            vente.setRevenue( Double.parseDouble( venteDTO.getRevenue() ) );
        }
        vente.setRecolte( venteDTO.getRecolte() );

        return vente;
    }

    protected List<Vente> venteDTOListToVenteList(List<VenteDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Vente> list1 = new ArrayList<Vente>( list.size() );
        for ( VenteDTO venteDTO : list ) {
            list1.add( venteDTOToVente( venteDTO ) );
        }

        return list1;
    }

    private Long detailArbreId(RecolteDetails recolteDetails) {
        if ( recolteDetails == null ) {
            return null;
        }
        Arbre arbre = recolteDetails.getArbre();
        if ( arbre == null ) {
            return null;
        }
        Long id = arbre.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
