package com.example.Citronix.DTO.vente;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for creating or updating a sale")
public class VenteReqDTO {

    @Schema(
            description = "Date of the sale",
            example = "2024-01-15",
            required = true,
            format = "date"
    )
    @NotNull(message = "amount is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Schema(
            description = "Price per unit",
            example = "25.50",
            required = true,
            minimum = "0.01"
    )
    @NotNull(message = "until price is mandatory")
    @Positive(message = "until price must be positive")
    private Double untilPrice;

    @Schema(
            description = "Name of the client",
            example = "John Doe",
            required = true
    )
    @NotBlank(message = "client is mandatory")
    private String client;

    @Schema(
            description = "ID of the associated harvest",
            example = "1",
            required = true
    )
    @NotNull(message = "recolte id is mandatory")
    private Long recolteId;
}
