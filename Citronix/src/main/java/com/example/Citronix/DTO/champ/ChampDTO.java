package com.example.Citronix.DTO.champ;

import com.example.Citronix.entity.Arbre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChampDTO {
    private Long id;
    private String name;
    private Double area;
    private Long ferme_id;
}
