package com.example.Citronix.DTO.vente;

import com.example.Citronix.entity.Recolte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteDTO {
    private Long id;
    private String date;
    private Double untilPrice;
    private String client;
    private Double revenue;
    private Long recolte;
}
