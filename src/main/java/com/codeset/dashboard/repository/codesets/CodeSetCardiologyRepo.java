package com.codeset.dashboard.repository.codesets;

import com.codeset.dashboard.model.codesets.CodeSetCardiology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CodeSetCardiologyRepo extends GenericCodeSetRepository<CodeSetCardiology> {
}
