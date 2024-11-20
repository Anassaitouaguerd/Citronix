package com.example.Citronix.DTO.vente;

import com.example.Citronix.entity.Recolte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteDTO {
    Long id;
    String date;
    String untilPrice;
    String client;
    Double type;
    String revenue;
    Recolte recolte;
}
