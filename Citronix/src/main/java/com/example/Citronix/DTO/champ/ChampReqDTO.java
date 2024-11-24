package com.example.Citronix.DTO.champ;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChampReqDTO {

    @NotBlank(message = "name is mandatory")
    @Size(min = 3, max = 255, message = "name must be between 3 and 255 characters")
    private String name;

    @NotNull(message = "area is mandatory")
    @Size(min = 1000, message = "area must be greater than 1000 m²")
    private Double area;

    @NotNull(message = "ferme_id is mandatory")
    private Long ferme_id;
}
