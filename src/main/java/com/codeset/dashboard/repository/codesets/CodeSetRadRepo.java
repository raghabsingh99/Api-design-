package com.codeset.dashboard.repository.codesets;

import com.codeset.dashboard.model.codesets.CodeSetRad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeSetRadRepo extends JpaRepository<CodeSetRad, Integer>, JpaSpecificationExecutor<CodeSetRad> {
}
