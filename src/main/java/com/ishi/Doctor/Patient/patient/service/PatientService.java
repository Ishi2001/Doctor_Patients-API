package com.ishi.Doctor.Patient.patient.service;

import com.ishi.Doctor.Patient.patient.Entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    boolean updatePatient(Patient patient, Long id);

    void addPatient(Patient patient);

    boolean removePatient(Long id);

    Patient getPatientById(Long id);
}
