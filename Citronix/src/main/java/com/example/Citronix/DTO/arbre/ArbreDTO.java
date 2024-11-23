package com.example.Citronix.DTO.arbre;

import com.example.Citronix.entity.enums.TreeStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for returning tree information")
public class ArbreDTO {
    @Schema(description = "Unique identifier of the tree", example = "1")
    private Long id;

    @Schema(description = "Date when the tree was planted", example = "2024-01-15")
    private LocalDate plantationDate;

    @Schema(description = "Current status of the tree", example = "HEALTHY", allowableValues = {"HEALTHY", "DISEASED", "TREATED", "REMOVED"})
    private TreeStatus status;

    @Schema(description = "ID of the field where the tree is planted", example = "1")
    private Long champId;

    @Schema(description = "Age of the tree in years", example = "5")
    private int age;

    @Schema(description = "Tree's productivity measure", example = "85.5")
    private double productivity;
}
