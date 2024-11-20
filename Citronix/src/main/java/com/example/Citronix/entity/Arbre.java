package com.example.Citronix.entity;

import com.example.Citronix.entity.enums.TreeStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "arbre")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Arbre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plantationDate")
    private LocalDate plantationDate;

    @Column(name = "status")
    private TreeStatus status;

    @ManyToOne
    @JoinColumn(name = "champ_id", nullable = false)
    private Champ champ;

    @OneToMany(mappedBy = "arbre")
    private List<RecolteDetails> recolteDetails;

}
