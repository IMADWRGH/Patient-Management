package com.imadwrgh.patientservice.mapper;

import com.imadwrgh.patientservice.dto.PatientResponseDTO;
import com.imadwrgh.patientservice.model.Patient;

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

//    public static Patient toEntity(PatientResponseDTO dto){
//        Patient patient=new Patient();
//
//        patient.setName(dto.getName());
//        patient.setEmail(dto.getEmail());
//        patient.setAddress(dto.getAddress());
//
//        return patient;
//    }
}
