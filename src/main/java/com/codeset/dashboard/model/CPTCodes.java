package com.codeset.dashboard.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CPTCodes")
@Data
public class CPTCodes {
    @Id
    private String cptCode;

    @Lob
    private String description;

    // Getters and setters
}
