package com.example.Citronix.DTO.recolte;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for creating or updating harvest details")
public class RecolteDetailsReqDTO {

    @Schema(
            description = "ID of the tree to harvest from",
            example = "1",
            required = true
    )
    @NotNull(message = "Arbre id is mandatory")
    private Long arbreId;

    @Schema(
            description = "Quantity to harvest in kilograms",
            example = "25.5",
            required = true,
            minimum = "0.1"
    )
    @NotNull(message = "Quantity is mandatory")
    @Positive
    private Double quantity;

}
