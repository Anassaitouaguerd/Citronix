package com.example.Citronix.DTO.arbre;

import com.example.Citronix.entity.enums.TreeStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for creating or updating a tree")
public class ArbreReqDTO {

    @Schema(
            description = "Date when the tree was/will be planted",
            example = "2024-01-15",
            required = true
    )
    @NotNull(message = "plantationDate is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate plantationDate;

    @Schema(
            description = "Current status of the tree",
            example = "HEALTHY",
            allowableValues = {"HEALTHY", "DISEASED", "TREATED", "REMOVED"}
    )
    private TreeStatus status;

    @Schema(
            description = "ID of the field where the tree is/will be planted",
            example = "1",
            required = true
    )
    @NotNull(message = "champ_id is mandatory")
    private Long champ_id;

}
