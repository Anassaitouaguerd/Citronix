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
    Long id;
    String name;
    Double area;
    Long ferme_id;
    List<Arbre> arbres;
}
