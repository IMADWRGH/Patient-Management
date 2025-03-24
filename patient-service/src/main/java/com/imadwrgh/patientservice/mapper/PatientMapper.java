package com.imadwrgh.patientservice.mapper;

import com.imadwrgh.patientservice.dto.PatientResponseDTO;
import com.imadwrgh.patientservice.model.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientResponseDTO= new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patientResponseDTO.getEmail());
        patientResponseDTO.setAddress(patientResponseDTO.getAddress());
        patientResponseDTO.setRegisterDate(patientResponseDTO.getRegisterDate());
        patientResponseDTO.setBirthDate(patientResponseDTO.getBirthDate());
        return patientResponseDTO;
    }
}
