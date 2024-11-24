package com.example.Citronix.DTO.recolte;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RecolteDetailsReqDTO {

    @NotNull(message = "Arbre id is mandatory")
    private Long arbreId;

    @NotNull(message = "Quantity is mandatory")
    @Positive
    private Double quantity;

}
