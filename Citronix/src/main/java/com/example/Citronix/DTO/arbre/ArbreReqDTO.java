package com.example.Citronix.DTO.arbre;

import com.example.Citronix.entity.enums.TreeStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArbreReqDTO {

    @NotNull(message = "plantationDate is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate plantationDate;

    private TreeStatus status;

    @NotNull(message = "champ_id is mandatory")
    private Long champ_id;

}
