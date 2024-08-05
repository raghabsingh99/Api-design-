package com.codeset.dashboard.model.codesets;


import com.codeset.dashboard.model.CPTCodes;
import com.codeset.dashboard.model.HealthPlan;
import com.codeset.dashboard.model.Modality;
import com.codeset.dashboard.model.Solution;
import com.codeset.dashboard.utils.MapToJsonConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Entity
@Table(name = "CodeSetRad")
@Data
public class CodeSetRad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SolutionId", nullable = false)
    private Solution solution;

    @ManyToOne
    @JoinColumn(name = "ModalityId", nullable = false)
    private Modality modality;

    @ManyToOne
    @JoinColumn(name = "HealthPlanId", nullable = false)
    private HealthPlan healthPlan;

    @ManyToOne
    @JoinColumn(name = "CPTCode", nullable = false)
    private CPTCodes cptCode;

    @Lob
    @Column(nullable = false)
    private String procedure;

    @Lob
    @Column(nullable = false)
    private String grouper;

    @Lob
    @Column(nullable = false)
    private String grouperIncluded;

    @Column
    private Integer quantity;

    @Lob
    @Column(nullable = false)
    private String defaultEnabled;

    @Lob
    private String grouperDefault;

    @Column(nullable = false)
    @Convert(converter = MapToJsonConverter.class)
    private Map<String, String> plans;

    @Column(nullable = false)
    private String year;

}
