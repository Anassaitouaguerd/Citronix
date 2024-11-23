package com.example.Citronix.DTO.farme;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for creating or updating a farm")
public class FermeReqDTO {

    @Schema(
            description = "Name of the farm",
            example = "Green Valley Farm",
            required = true,
            minLength = 3,
            maxLength = 255
    )
    @NotBlank(message = "name is mandatory")
    @Size(min = 3, max = 255, message = "name must be between 3 and 255 characters")
    private String name;

    @Schema(
            description = "Physical location of the farm",
            example = "123 Rural Road, County",
            required = true,
            minLength = 3,
            maxLength = 255
    )
    @NotBlank(message = "Location is mandatory")
    @Size(min = 3, max = 255, message = "Location must be between 3 and 255 characters")
    private String location;

    @Schema(
            description = "Total area of the farm in hectares",
            example = "150.5",
            required = true,
            minimum = "0"
    )
    @NotNull(message = "area is mandatory")
    private Double area;

}
