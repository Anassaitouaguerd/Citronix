package com.example.Citronix.mapper;

import com.example.Citronix.DTO.recolte.RecolteDTO;
import com.example.Citronix.DTO.recolte.RecolteDetailDTO;
import com.example.Citronix.DTO.recolte.RecolteReqDTO;
import com.example.Citronix.entity.Arbre;
import com.example.Citronix.entity.Champ;
import com.example.Citronix.entity.Recolte;
import com.example.Citronix.entity.RecolteDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-23T14:20:52+0100",
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
        recolteDTO.setRecolteDetails( recolteDetailsListToRecolteDetailDTOList( harvest.getRecolteDetails() ) );

        return recolteDTO;
    }

    @Override
    public Recolte toEntity(RecolteReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Recolte.RecolteBuilder recolte = Recolte.builder();

        recolte.champ( mapChamp( dto.getChampId() ) );
        recolte.recolteDate( dto.getRecolteDate() );

        return recolte.build();
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

        RecolteDetails.RecolteDetailsBuilder recolteDetails = RecolteDetails.builder();

        recolteDetails.arbre( mapArbre( dto.getArbreId() ) );
        recolteDetails.id( dto.getId() );
        recolteDetails.quantity( dto.getQuantity() );

        return recolteDetails.build();
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

    protected List<RecolteDetailDTO> recolteDetailsListToRecolteDetailDTOList(List<RecolteDetails> list) {
        if ( list == null ) {
            return null;
        }

        List<RecolteDetailDTO> list1 = new ArrayList<RecolteDetailDTO>( list.size() );
        for ( RecolteDetails recolteDetails : list ) {
            list1.add( toDetailDTO( recolteDetails ) );
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
