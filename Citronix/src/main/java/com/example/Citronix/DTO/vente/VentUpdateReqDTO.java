package com.example.Citronix.DTO.vente;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VentUpdateReqDTO {
    @NotNull(message = "amount is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "until price is mandatory")
    private Double untilPrice;

    @NotBlank(message = "client is mandatory")
    private String client;

    @NotNull(message = "revenu is mandatory")
    private Double revenu;
}

