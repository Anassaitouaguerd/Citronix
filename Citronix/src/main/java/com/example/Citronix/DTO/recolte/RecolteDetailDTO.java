package com.example.Citronix.DTO.recolte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "DTO for returning harvest detail information")
public class RecolteDetailDTO {
    @Schema(description = "Unique identifier of the harvest detail", example = "1")
    private Long id;

    @Schema(description = "ID of the tree associated with this harvest", example = "1")
    private Long arbreId;

    @Schema(description = "Quantity harvested from this tree in kilograms", example = "25.5")
    private Double quantity;
}

