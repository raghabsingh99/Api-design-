package com.codeset.dashboard.repository.codesets;


import com.codeset.dashboard.model.codesets.CodeSetRehab;
import com.codeset.dashboard.model.codesets.CodeSetSleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeSetSleepRepo extends JpaRepository<CodeSetSleep, Integer>, JpaSpecificationExecutor<CodeSetSleep> {
}
