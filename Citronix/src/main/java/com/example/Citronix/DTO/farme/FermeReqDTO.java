package com.example.Citronix.DTO.farme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FermeReqDTO {

    @NotBlank(message = "name is mandatory")
    @Size(min = 3, max = 255, message = "name must be between 3 and 255 characters")
    private String name;

    @NotBlank(message = "Location is mandatory")
    @Size(min = 3, max = 255, message = "Location must be between 3 and 255 characters")
    private String location;

    @NotNull(message = "area is mandatory")
    private Double area;

}
