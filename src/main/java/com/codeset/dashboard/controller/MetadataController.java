package com.codeset.dashboard.controller;


import com.codeset.dashboard.dto.DropdownDTO;
import com.codeset.dashboard.service.MetadataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/metadata")
public class MetadataController {


    private final MetadataService metadataService;

    public MetadataController(MetadataService metadataService) {
        this.metadataService = metadataService;
    }


    @GetMapping
    @SuppressWarnings("unchecked")
    public ResponseEntity<Map<String, List<DropdownDTO>>> getFilterMetadata() {
        CompletableFuture<List<DropdownDTO>> healthPlansFuture = metadataService.getHealthPlanMetadata();
        CompletableFuture<List<DropdownDTO>> statesFuture = metadataService.getStateMetadata();
        CompletableFuture<List<DropdownDTO>> cptCodesFuture = metadataService.getCptCodeMetadata();
        CompletableFuture<List<DropdownDTO>> solutionsFuture = metadataService.getSolutionMetadata();

        CompletableFuture<Map<String, List<DropdownDTO>>> dropdowns =  CompletableFuture.allOf(healthPlansFuture, statesFuture, cptCodesFuture, solutionsFuture)
                .thenApply(v -> {
                    Map<String, List<DropdownDTO>> metadata = new HashMap<>();
                    try {
                        metadata.put("healthPlans", healthPlansFuture.get());
                        metadata.put("states", statesFuture.get());
                        metadata.put("cptCodes", cptCodesFuture.get());
                        metadata.put("solutions", solutionsFuture.get());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return metadata;
                });
        return ResponseEntity.ok(dropdowns.join());

    }
}
