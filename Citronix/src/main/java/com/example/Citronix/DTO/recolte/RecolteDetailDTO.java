package com.example.Citronix.DTO.recolte;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecolteDetailDTO {
    private Long id;
    private Long arbreId;
    private Double quantity;
}

