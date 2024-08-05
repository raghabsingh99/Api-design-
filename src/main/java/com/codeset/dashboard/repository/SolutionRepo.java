package com.codeset.dashboard.repository;


import com.codeset.dashboard.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepo extends JpaRepository<Solution, Integer> {
}
