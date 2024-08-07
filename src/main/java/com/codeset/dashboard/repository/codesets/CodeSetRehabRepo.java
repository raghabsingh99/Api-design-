package com.codeset.dashboard.repository.codesets;


import com.codeset.dashboard.model.codesets.CodeSetRBM;
import com.codeset.dashboard.model.codesets.CodeSetRehab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeSetRehabRepo extends JpaRepository<CodeSetRehab, Integer>, JpaSpecificationExecutor<CodeSetRehab> {
}
