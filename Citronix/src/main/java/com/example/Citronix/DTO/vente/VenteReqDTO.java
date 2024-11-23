package com.example.Citronix.DTO.vente;

import com.fasterxml.jackson.annotation.JsonFormat;
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

public class VenteReqDTO {

    @NotNull(message = "amount is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "until price is mandatory")
    @Positive(message = "until price must be positive")
    private Double untilPrice;

    @NotBlank(message = "client is mandatory")
    private String client;

    @NotNull(message = "recolte id is mandatory")
    private Long recolteId;
}
