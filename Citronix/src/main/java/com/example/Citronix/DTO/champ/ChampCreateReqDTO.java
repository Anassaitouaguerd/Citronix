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
public class ChampCreateReqDTO {

    @NotBlank(message = "name is mandatory")
    @Size(min = 3, max = 255, message = "name must be between 3 and 255 characters")
    private String name;

    @NotNull(message = "area is mandatory")
    private Double area;
}
