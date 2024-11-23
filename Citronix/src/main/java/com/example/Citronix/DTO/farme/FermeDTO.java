package com.example.Citronix.DTO.farme;

import com.example.Citronix.entity.Champ;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for returning farm information")
public class FermeDTO {
    @Schema(description = "Unique identifier of the farm", example = "1")
    private Long id;

    @Schema(description = "Name of the farm", example = "Green Valley Farm")
    private String name;

    @Schema(description = "Physical location of the farm", example = "123 Rural Road, County")
    private String location;

    @Schema(description = "Total area of the farm in hectares", example = "150.5")
    private Double area;

    @Schema(description = "Date and time when the farm was created", example = "2024-01-15T10:30:00")
    private LocalDateTime creationDate;

    @Schema(description = "List of fields belonging to this farm")
    private List<Champ> champs;
}
