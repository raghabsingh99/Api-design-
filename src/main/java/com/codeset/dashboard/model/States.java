package com.codeset.dashboard.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "States")
@Data
public class States {

    @Id
    private String id;

    @Column(nullable = false)
    private String stateName;
}
