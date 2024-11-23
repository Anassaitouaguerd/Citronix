package com.example.Citronix.DTO.vente;

import com.example.Citronix.entity.Recolte;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for returning sale information")
public class VenteDTO {
    @Schema(description = "Unique identifier of the sale", example = "1")
    private Long id;

    @Schema(description = "Date of the sale", example = "2024-01-15")
    private String date;

    @Schema(description = "Price per unit", example = "25.50")
    private Double untilPrice;

    @Schema(description = "Name of the client", example = "John Doe")
    private String client;

    @Schema(description = "Total revenue from the sale", example = "2550.00")
    private Double revenue;

    @Schema(description = "ID of the associated harvest", example = "1")
    private Long recolte;
}
