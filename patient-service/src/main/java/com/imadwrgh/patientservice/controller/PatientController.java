package com.imadwrgh.patientservice.controller;


import com.imadwrgh.patientservice.Service.PatientService;
import com.imadwrgh.patientservice.dto.PatientRequestDTO;
import com.imadwrgh.patientservice.dto.PatientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<PatientResponseDTO>> listPatients(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok().body(patientService.list(pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<PatientResponseDTO> create(@RequestBody PatientRequestDTO patientRequestDTO){
        return ResponseEntity.ok().body(patientService.create(patientRequestDTO));
    }
}
