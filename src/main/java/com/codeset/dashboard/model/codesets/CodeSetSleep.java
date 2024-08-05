package com.codeset.dashboard.model.codesets;


import com.codeset.dashboard.model.CPTCodes;
import com.codeset.dashboard.model.HealthPlan;
import com.codeset.dashboard.model.Solution;
import com.codeset.dashboard.utils.MapToJsonConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Entity
@Table(name = "CodeSetSleep")
@Data
public class CodeSetSleep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SolutionId", nullable = false)
    private Solution solution;

    @ManyToOne
    @JoinColumn(name = "CPTCode", nullable = false)
    private CPTCodes cptCode;

    @Lob
    @Column(nullable = false)
    private String grouper;

    private Integer quantity;

    @Lob
    @Column(nullable = false)
    private String qualifier;

    @Lob
    @Column(nullable = false)
    private String authTimeFrame;

    @Lob
    @Column(nullable = false)
    private String typeOfService;

    @Lob
    @Column(nullable = false)
    private String placeOfService;


    @Column(nullable = false)
    @Convert(converter = MapToJsonConverter.class)
    private Map<String, String> plans;

    @Column(nullable = false)
    private String year;

    @ManyToOne
    @JoinColumn(name = "HealthPlanId", nullable = false)
    private HealthPlan healthPlan;

}
