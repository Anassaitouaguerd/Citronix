package com.example.Citronix.DTO.recolte;

import com.example.Citronix.entity.enums.SeasonType;
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
public class RecolteReqDTO {

    @NotNull(message = "Recolte date is mandatory")
    private LocalDate recolteDate;

    @NotNull(message = "comp id is mandatory")
    private Long champId;

    @NotEmpty(message = "Recolte details is mandatory")
    private List<RecolteDetailsReqDTO> recolteDetails;

}
