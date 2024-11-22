package com.example.Citronix.entity;

import com.example.Citronix.entity.enums.SeasonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "recolte")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recolte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "season")
    private SeasonType season;

    @Column(name = "recolteDate")
    private LocalDate recolteDate = LocalDate.now();

    @Column(name = "totalQuantity")
    private Double totalQuantity;

    @ManyToOne
    @JoinColumn(name = "champ_id")
    private Champ champ;

    @OneToMany(mappedBy = "recolte", cascade = CascadeType.ALL)
    private List<RecolteDetails> recolteDetails;

    @OneToMany(mappedBy = "recolte")
    private List<Vente> vents;
}
