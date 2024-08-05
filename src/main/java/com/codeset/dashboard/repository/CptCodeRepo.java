package com.codeset.dashboard.repository;

import com.codeset.dashboard.model.CPTCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CptCodeRepo extends JpaRepository<CPTCodes, String> {
}
