package com.example.Citronix.DTO.champ;

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
@Schema(description = "DTO for creating or updating a field")
public class ChampReqDTO {

    @Schema(
            description = "Name of the field",
            example = "North Field",
            required = true,
            minLength = 3,
            maxLength = 255
    )
    @NotBlank(message = "name is mandatory")
    @Size(min = 3, max = 255, message = "name must be between 3 and 255 characters")
    private String name;

    @Schema(
            description = "Area of the field in square meters",
            example = "5000.0",
            required = true,
            minimum = "1000"
    )
    @NotNull(message = "area is mandatory")
    @Size(min = 1000, message = "area must be greater than 1000 m²")
    private Double area;

    @Schema(
            description = "ID of the farm this field belongs to",
            example = "1",
            required = true
    )
    @NotNull(message = "ferme_id is mandatory")
    private Long ferme_id;
}
