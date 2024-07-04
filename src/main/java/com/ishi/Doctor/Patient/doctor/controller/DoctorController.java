package com.ishi.Doctor.Patient.doctor.controller;

import com.ishi.Doctor.Patient.doctor.Entity.Doctor;
import com.ishi.Doctor.Patient.doctor.service.impl.DoctorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorServiceImpl doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addDoctor(@Valid @RequestBody Doctor doctor, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessageList = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessageList);

        }
        doctorService.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Doctor Added Sucessfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateDoctor(@PathVariable("id") Long id,
                                       @Valid @RequestBody Doctor doctor,
                                       BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessageList = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessageList);

        }
        doctorService.updateDoctor(doctor, id);
        return ResponseEntity.status(HttpStatus.OK).body("Doctor updated Sucessfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeDoctor(@PathVariable Long id) {
        boolean isDeleted = doctorService.removeDoctor(id);
        if (isDeleted) {
            return new ResponseEntity<>("Doctor Successfully removed", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Doctor Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable("id") Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}

