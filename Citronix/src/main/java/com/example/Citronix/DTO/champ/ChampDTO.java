package com.example.Citronix.DTO.champ;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for returning field information")
public class ChampDTO {
    @Schema(description = "Unique identifier of the field", example = "1")
    private Long id;

    @Schema(description = "Name of the field", example = "North Field")
    private String name;

    @Schema(description = "Area of the field in square meters", example = "5000.0")
    private Double area;

    @Schema(description = "ID of the farm this field belongs to", example = "1")
    private Long ferme_id;
}
