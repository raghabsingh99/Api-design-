package com.codeset.dashboard.service;


import com.codeset.dashboard.constants.CodeSetEnum;
import com.codeset.dashboard.dto.DropdownDTO;
import com.codeset.dashboard.model.CPTCodes;
import com.codeset.dashboard.model.HealthPlan;
import com.codeset.dashboard.model.States;
import com.codeset.dashboard.repository.CptCodeRepo;
import com.codeset.dashboard.repository.HealthPlanRepo;
import com.codeset.dashboard.repository.StateRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class MetadataService {


    private final CptCodeRepo cptCodeRepo;
    private final HealthPlanRepo healthPlanRepo;
    private final StateRepo stateRepo;

    public MetadataService(CptCodeRepo cptCodeRepo, HealthPlanRepo healthPlanRepo, StateRepo stateRepo) {
        this.cptCodeRepo = cptCodeRepo;
        this.healthPlanRepo = healthPlanRepo;
        this.stateRepo = stateRepo;
    }


    @Async
    @Cacheable("solutions")
    public CompletableFuture<List<DropdownDTO>> getSolutionMetadata() {
        List<DropdownDTO> solutions = Arrays.stream(CodeSetEnum.values())
                .map(codeSetEnum -> new DropdownDTO(codeSetEnum.name(), codeSetEnum.codeSetName))
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(solutions);
    }

    @Async
    @Cacheable("cptCodes")
    public CompletableFuture<List<DropdownDTO>> getCptCodeMetadata() {
        List<CPTCodes> cptCodes = cptCodeRepo.findAll();
        List<DropdownDTO> cptCodeDTOs = cptCodes.stream()
                .map(cpt -> new DropdownDTO(cpt.getCptCode(), cpt.getCptCode()))
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(cptCodeDTOs);
    }

    @Async
    @Cacheable("healthPlans")
    public CompletableFuture<List<DropdownDTO>> getHealthPlanMetadata() {
        List<HealthPlan> healthPlans = healthPlanRepo.findAll();
        List<DropdownDTO> healthPlanDTOs = healthPlans.stream()
                .map(healthPlan -> new DropdownDTO(healthPlan.getName(), healthPlan.getId().toString()))
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(healthPlanDTOs);
    }

    @Async
    @Cacheable("states")
    public CompletableFuture<List<DropdownDTO>> getStateMetadata() {
        List<States> states = stateRepo.findAll();
        List<DropdownDTO> stateDTOs = states.stream()
                .map(state -> new DropdownDTO(state.getStateName(), state.getId()))
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(stateDTOs);
    }
}
