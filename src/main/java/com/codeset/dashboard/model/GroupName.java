package com.codeset.dashboard.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "GroupName")
public class GroupName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    // Getters and setters
}
