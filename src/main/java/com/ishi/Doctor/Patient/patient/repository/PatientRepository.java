package com.ishi.Doctor.Patient.patient.repository;

import com.ishi.Doctor.Patient.patient.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
