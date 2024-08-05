package com.codeset.dashboard.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Modality")
@Data
public class Modality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "SolutionId", nullable = false)
    private Solution solution;

    // Getters and setters
}
