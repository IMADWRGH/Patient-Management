package com.imadwrgh.patientservice.Service.ServiceImpl;


import com.imadwrgh.patientservice.Repository.PatientRepo;
import com.imadwrgh.patientservice.Service.PatientService;
import com.imadwrgh.patientservice.dto.PatientRequestDTO;
import com.imadwrgh.patientservice.dto.PatientResponseDTO;
import com.imadwrgh.patientservice.mapper.PatientMapper;
import com.imadwrgh.patientservice.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

private final PatientRepo patientRepo;

    public PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Page<PatientResponseDTO> list(Pageable pageable){
         Page<Patient> patients = patientRepo.findAll(pageable);
          return patients.map(PatientMapper::toDTO);
    }

    @Override
    public PatientResponseDTO create(PatientRequestDTO patientRequestDTO) {
        return null;
    }

    @Override
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {
        return null;
    }

    @Override
    public void deletePatient(UUID id) {

    }


}
