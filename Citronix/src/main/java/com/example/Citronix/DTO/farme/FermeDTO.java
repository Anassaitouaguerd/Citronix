package com.example.Citronix.DTO.farme;

import com.example.Citronix.entity.Champ;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FermeDTO {
    private Long id;
    private String name;
    private String location;
    private Double area;
    private LocalDateTime creationDate;
    private List<Champ> champs;
}
