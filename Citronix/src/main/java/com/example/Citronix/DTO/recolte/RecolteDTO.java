package com.example.Citronix.DTO.recolte;

import com.example.Citronix.entity.RecolteDetails;
import com.example.Citronix.entity.Vente;
import com.example.Citronix.entity.enums.SeasonType;

import java.time.LocalDateTime;
import java.util.List;

public class RecolteDTO {
    Long id;
    SeasonType season;
    Double amount;
    Double totalQuantity;
    LocalDateTime HarvestDate;
    List<Vente> vents;
    List<RecolteDetails> recolteDetails;
}
