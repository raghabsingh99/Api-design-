package com.codeset.dashboard.service;


import com.codeset.dashboard.constants.CodeSetEnum;
import com.codeset.dashboard.model.codesets.*;
import com.codeset.dashboard.repository.codesets.*;
import com.codeset.dashboard.utils.CodeSetSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CodeSetService {

    @Autowired
    private CodeSetMSKRepo codeSetMSKRepository;

    @Autowired
    private CodeSetRadRepo codeSetRadRepository;

    @Autowired
    private CodeSetSleepRepo codeSetSleepRepository;

    @Autowired
    private CodeSetRBMRepo codeSetRBMRepository;

    @Autowired
    private CodeSetRehabRepo codeSetRehabRepository;

    @Autowired
    private CodeSetCardiologyRepo codeSetCardiologyRepository;


    @SuppressWarnings("unchecked")
    public <T> Page<T> searchCodeSets(String clazz, Integer solutionId, Integer healthPlanId, String cptCode, String stateId, Pageable pageable) {
        CodeSetSpecification<T> specification = new CodeSetSpecification<>(solutionId, healthPlanId, cptCode, stateId);

        if (Objects.equals(clazz, CodeSetEnum.MSK.codeSetName)) {
            return (Page<T>) codeSetMSKRepository.findAll((Specification<CodeSetMSK>) specification, pageable);
        } else if (clazz == CodeSetEnum.RAD.codeSetName) {
            return (Page<T>) codeSetRadRepository.findAll((Specification<CodeSetRad>) specification, pageable);
        } else if (clazz == CodeSetEnum.SLEEP.codeSetName) {
            return (Page<T>) codeSetSleepRepository.findAll((Specification<CodeSetSleep>) specification, pageable);
        } else if (clazz == CodeSetEnum.RBM.codeSetName) {
            return (Page<T>) codeSetRBMRepository.findAll((Specification<CodeSetRBM>) specification, pageable);
        } else if (clazz == CodeSetEnum.REHAB.codeSetName) {
            return (Page<T>) codeSetRehabRepository.findAll((Specification<CodeSetRehab>) specification, pageable);
        } else if (clazz == CodeSetEnum.CARDIOLOGY.codeSetName) {
            return (Page<T>) codeSetCardiologyRepository.findAll((Specification<CodeSetCardiology>) specification, pageable);
        } else {
            throw new IllegalArgumentException("Unknown class: " + clazz);
        }
    }


}
