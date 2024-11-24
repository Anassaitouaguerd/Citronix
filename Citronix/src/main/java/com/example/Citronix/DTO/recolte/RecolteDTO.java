package com.example.Citronix.DTO.recolte;

import com.example.Citronix.DTO.vente.VenteDTO;
import com.example.Citronix.entity.RecolteDetails;
import com.example.Citronix.entity.Vente;
import com.example.Citronix.entity.enums.SeasonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecolteDTO {
    private Long id;
    private SeasonType season;
    private Double totalQuantity;
    private LocalDate recolteDate;
    private Long champId;
    private List<RecolteDetailDTO> recolteDetails;
}
