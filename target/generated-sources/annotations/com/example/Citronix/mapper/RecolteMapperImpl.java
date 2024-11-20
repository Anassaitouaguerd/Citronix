package com.example.Citronix.mapper;

import com.example.Citronix.DTO.recolte.RecolteDTO;
import com.example.Citronix.DTO.recolte.RecolteReqDTO;
import com.example.Citronix.entity.Recolte;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T21:56:39+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class RecolteMapperImpl implements RecolteMapper {

    @Override
    public Recolte toEntity(RecolteDTO recolteDTO) {
        if ( recolteDTO == null ) {
            return null;
        }

        Recolte recolte = new Recolte();

        return recolte;
    }

    @Override
    public Recolte toEntity(RecolteReqDTO recolteReqDTO) {
        if ( recolteReqDTO == null ) {
            return null;
        }

        Recolte recolte = new Recolte();

        recolte.setSeason( recolteReqDTO.getSeason() );
        recolte.setAmount( recolteReqDTO.getAmount() );
        recolte.setTotalQuantity( recolteReqDTO.getTotalQuantity() );

        return recolte;
    }

    @Override
    public RecolteDTO toDTO(Recolte recolte) {
        if ( recolte == null ) {
            return null;
        }

        RecolteDTO recolteDTO = new RecolteDTO();

        return recolteDTO;
    }
}
