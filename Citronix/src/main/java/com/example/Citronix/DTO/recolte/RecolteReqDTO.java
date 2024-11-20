package com.example.Citronix.DTO.recolte;

import com.example.Citronix.entity.enums.SeasonType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecolteReqDTO {

    @NotNull(message = "season type is mandatory")
    private SeasonType season;

    @NotNull(message = "amount is mandatory")
    private Double amount;

    @NotNull(message = "total quantity is mandatory")
    private Double totalQuantity;

}
