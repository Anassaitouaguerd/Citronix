package com.example.Citronix.DTO.arbre;

import com.example.Citronix.entity.RecolteDetails;
import com.example.Citronix.entity.enums.TreeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArbreDTO {
    private Long id;
    private LocalDate plantationDate;
    private TreeStatus status;
    private Long champId;
}
