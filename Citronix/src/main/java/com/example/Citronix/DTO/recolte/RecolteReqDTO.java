package com.example.Citronix.DTO.recolte;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for creating or updating a harvest")
public class RecolteReqDTO {


    @Schema(
            description = "Date when the harvest takes/took place",
            example = "2024-01-15",
            required = true,
            format = "date"
    )
    @NotNull(message = "Recolte date is mandatory")
    private LocalDate recolteDate;

    @Schema(
            description = "ID of the field where the harvest takes place",
            example = "1",
            required = true
    )
    @NotNull(message = "comp id is mandatory")
    private Long champId;

    @Schema(
            description = "List of harvest details for individual trees",
            required = true
    )
    @NotEmpty(message = "Recolte details is mandatory")
    private List<RecolteDetailsReqDTO> recolteDetails;

}
