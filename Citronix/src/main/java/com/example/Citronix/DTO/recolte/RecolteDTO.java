package com.example.Citronix.DTO.recolte;

import com.example.Citronix.entity.enums.SeasonType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for returning harvest information")
public class RecolteDTO {
    @Schema(description = "Unique identifier of the harvest", example = "1")
    private Long id;

    @Schema(
            description = "Season during which the harvest took place",
            example = "SUMMER",
            allowableValues = {"SPRING", "SUMMER", "AUTUMN", "WINTER"}
    )
    private SeasonType season;

    @Schema(
            description = "Total quantity harvested in kilograms",
            example = "1250.5"
    )
    private Double totalQuantity;

    @Schema(
            description = "Date when the harvest took place",
            example = "2024-01-15"
    )
    private LocalDate recolteDate;

    @Schema(
            description = "ID of the field where the harvest took place",
            example = "1"
    )
    private Long champId;

    @Schema(
            description = "List of detailed harvest information per tree"
    )
    private List<RecolteDetailDTO> recolteDetails;
}
