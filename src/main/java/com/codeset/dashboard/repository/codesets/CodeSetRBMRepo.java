package com.codeset.dashboard.repository.codesets;


import com.codeset.dashboard.model.codesets.CodeSetRBM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeSetRBMRepo extends GenericCodeSetRepository<CodeSetRBM> {
}
