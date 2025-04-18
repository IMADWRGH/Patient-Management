package com.imadwrgh.patientservice.Service;


import com.imadwrgh.patientservice.dto.PatientRequestDTO;
import com.imadwrgh.patientservice.dto.PatientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PatientService {
     Page<PatientResponseDTO> list(Pageable pageable);
     PatientResponseDTO create(PatientRequestDTO patientRequestDTO);
     PatientResponseDTO updatePatient(UUID id,PatientRequestDTO patientRequestDTO);
     void deletePatient(UUID id);
}
