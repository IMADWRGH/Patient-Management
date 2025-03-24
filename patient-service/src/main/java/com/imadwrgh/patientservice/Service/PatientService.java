package com.imadwrgh.patientservice.Service;


import com.imadwrgh.patientservice.dto.PatientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientService {
     Page<PatientResponseDTO> list(Pageable pageable);
}
