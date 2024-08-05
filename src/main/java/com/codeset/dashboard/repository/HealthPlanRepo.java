package com.codeset.dashboard.repository;


import com.codeset.dashboard.model.HealthPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthPlanRepo extends JpaRepository<HealthPlan, Integer > {
}
