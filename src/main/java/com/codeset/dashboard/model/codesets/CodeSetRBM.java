package com.codeset.dashboard.model.codesets;

import com.codeset.dashboard.model.*;
import com.codeset.dashboard.utils.MapToJsonConverter;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CodeSetRBM")

@Data
public class CodeSetRBM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SolutionId", nullable = false)
    private Solution solution;

    @ManyToOne
    @JoinColumn(name = "ModalityId")
    private Modality modality;

    @ManyToOne
    @JoinColumn(name = "HealthPlanId", nullable = false)
    private HealthPlan healthPlan;

    @ManyToOne
    @JoinColumn(name = "CPTCode", nullable = false)
    private CPTCodes cptCode;

    @Column(name = "ProcedureNumber")
    private String procedureNumber;

    @Lob
    @Column(name = "Procedure")
    private String procedure;

    @Column(nullable = false)
    @Convert(converter = MapToJsonConverter.class)
    private String plans;

    @Column(nullable = false)
    private String year;

    @ManyToOne
    @JoinColumn(name = "Location")
    private States location;


}
