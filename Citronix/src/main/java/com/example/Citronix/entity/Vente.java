package com.example.Citronix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "vente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "unitPrice")
    private Double unitPrice;

    @Column(name = "client")
    private String client;

    @Column(name = "Revenue")
    private Double Revenue;
}
