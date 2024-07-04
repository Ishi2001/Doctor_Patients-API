package com.ishi.Doctor.Patient.doctor.repository;

import com.ishi.Doctor.Patient.doctor.Entity.Speciality;
import com.ishi.Doctor.Patient.doctor.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, Speciality speciality);
}
