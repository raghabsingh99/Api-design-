package com.codeset.dashboard.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "HealthPlan")
@Data
public class HealthPlan {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GroupId", nullable = false)
    private GroupName groupName;

    // Getters and setters
}
