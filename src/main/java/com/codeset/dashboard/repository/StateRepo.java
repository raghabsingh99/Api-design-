package com.codeset.dashboard.repository;


import com.codeset.dashboard.model.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository<States, String> {
}
