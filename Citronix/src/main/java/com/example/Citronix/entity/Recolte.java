package com.example.Citronix.entity;

import com.example.Citronix.entity.enums.SeasonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    @Column(name = "amount")
    private Double amount;

    @Column(name = "HarvestDate")
    private LocalDateTime HarvestDate = LocalDateTime.now();

    @Column(name = "totalQuantity")
    private Double totalQuantity;
}
