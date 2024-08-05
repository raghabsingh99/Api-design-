package com.codeset.dashboard.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Solution")
@Data
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

}
