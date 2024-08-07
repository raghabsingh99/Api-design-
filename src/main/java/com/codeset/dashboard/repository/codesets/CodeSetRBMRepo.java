package com.codeset.dashboard.repository.codesets;


import com.codeset.dashboard.model.codesets.CodeSetRBM;
import com.codeset.dashboard.model.codesets.CodeSetRad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeSetRBMRepo extends JpaRepository<CodeSetRBM, Integer>, JpaSpecificationExecutor<CodeSetRBM> {
}
