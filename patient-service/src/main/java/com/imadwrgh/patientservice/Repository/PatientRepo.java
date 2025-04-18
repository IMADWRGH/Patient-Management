package com.imadwrgh.patientservice.Repository;


import com.imadwrgh.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepo extends JpaRepository<Patient, UUID> {
  boolean  existsByEmail(String email);
  boolean existsByEmailAndIdNot(String email ,UUID id);
}
