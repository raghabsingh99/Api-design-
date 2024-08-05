package com.codeset.dashboard.utils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CodeSetSpecification<T> implements Specification<T> {
    private Integer solutionId;
    private Integer healthPlanId;
    private String cptCode;
    private String stateId;

    public CodeSetSpecification(Integer solutionId, Integer healthPlanId, String cptCode, String stateId) {
        this.solutionId = solutionId;
        this.healthPlanId = healthPlanId;
        this.cptCode = cptCode;
        this.stateId = stateId;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (solutionId != null) {
            predicates.add(criteriaBuilder.equal(root.get("solution").get("id"), solutionId));
        }
        if (healthPlanId != null) {
            predicates.add(criteriaBuilder.equal(root.get("healthPlan").get("id"), healthPlanId));
        }
        if (cptCode != null) {
            predicates.add(criteriaBuilder.equal(root.get("cptCode").get("cptCode"), cptCode));
        }
        if (stateId != null) {
            predicates.add(criteriaBuilder.equal(root.get("location").get("id"), stateId));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}