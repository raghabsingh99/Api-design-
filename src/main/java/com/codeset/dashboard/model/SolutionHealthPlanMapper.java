package com.codeset.dashboard.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SolutionHealthPlanMapper")
@Data
public class SolutionHealthPlanMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "HEALTH_PLAN_ID", nullable = false)
    private HealthPlan healthPlan;

    @ManyToOne
    @JoinColumn(name = "SOLUTION_ID", nullable = false)
    private Solution solution;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int month;
}
