package com.imadwrgh.patientservice.mapper;

import com.imadwrgh.patientservice.dto.PatientRequestDTO;
import com.imadwrgh.patientservice.dto.PatientResponseDTO;
import com.imadwrgh.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setRegisterDate(patient.getRegisterDate().toString());
        patientResponseDTO.setBirthDate(patient.getBirthDate().toString());
        return patientResponseDTO;
    }

    public static Patient toEntity(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setBirthDate(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisterDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        return patient;
    }
}
