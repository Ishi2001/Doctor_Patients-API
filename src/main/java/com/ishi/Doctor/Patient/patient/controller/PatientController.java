package com.ishi.Doctor.Patient.patient.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.ishi.Doctor.Patient.patient.Entity.Patient;
import com.ishi.Doctor.Patient.patient.service.impl.PatientServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addPatient(@Valid @RequestBody Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessageList = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessageList);

        }
        patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient Added Sucessfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePatient(@PathVariable("id") Long id, @Valid @RequestBody Patient patient,
                                        BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessageList = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessageList);

        }
        patientService.updatePatient(patient, id);
        return ResponseEntity.status(HttpStatus.OK).body("Patient updated Sucessfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removePatient(@Valid @PathVariable Long id) {
        boolean isDeleted = patientService.removePatient(id);
        if (isDeleted) {
            return new ResponseEntity<>("Patient Successfully removed", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Patient Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable("id") Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}

