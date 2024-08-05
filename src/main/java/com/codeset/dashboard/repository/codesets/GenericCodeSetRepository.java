package com.codeset.dashboard.repository.codesets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericCodeSetRepository<T> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
    // Common search methods can be defined here if needed
}
