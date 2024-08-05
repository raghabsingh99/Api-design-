package com.codeset.dashboard.controller;


import com.codeset.dashboard.constants.CodeSetEnum;
import com.codeset.dashboard.service.CodeSetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code-sets")
public class CodeSetController {

    private final CodeSetService codeSetService;

    public CodeSetController(CodeSetService codeSetService) {
        this.codeSetService = codeSetService;
    }

    @GetMapping("/search")
    public <T> Page<T> searchCodeSets(
            @RequestParam String clazz,
            @RequestParam(required = false) Integer solutionId,
            @RequestParam(required = false) Integer healthPlanId,
            @RequestParam(required = false) String cptCode,
            @RequestParam(required = false) String stateId,
            Pageable pageable) {
        return codeSetService.searchCodeSets(clazz, solutionId, healthPlanId, cptCode, stateId, pageable);
    }

}
