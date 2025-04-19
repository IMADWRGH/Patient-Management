package com.imadwrgh.patientservice.Service.ServiceImpl;


import com.imadwrgh.patientservice.Repository.PatientRepo;
import com.imadwrgh.patientservice.Service.PatientService;
import com.imadwrgh.patientservice.dto.PatientRequestDTO;
import com.imadwrgh.patientservice.dto.PatientResponseDTO;
import com.imadwrgh.patientservice.exception.EmailAlreadyExistsException;
import com.imadwrgh.patientservice.exception.PatientNotFoundException;
import com.imadwrgh.patientservice.mapper.PatientMapper;
import com.imadwrgh.patientservice.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        if(patientRepo.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException(String.format("this email is already exist : %s",patientRequestDTO.getEmail()));
        }
        Patient patient=patientRepo.save(PatientMapper.toEntity(patientRequestDTO));
        return PatientMapper.toDTO(patient);
    }

    @Override
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {
        Patient patient =patientRepo.findById(id)
                .orElseThrow(()->new PatientNotFoundException(String.format("this patient not found : %s",id)));
        if (patientRepo.existsByEmailAndIdNot(patientRequestDTO.getEmail(),
                id)) {
            throw new EmailAlreadyExistsException(
                    "A patient with this email " + "already exists"
                            + patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setBirthDate(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepo.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }

    @Override
    public void deletePatient(UUID id) {
        patientRepo.deleteById(id);
    }


}
