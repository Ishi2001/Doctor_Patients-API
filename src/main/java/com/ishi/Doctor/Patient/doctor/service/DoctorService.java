package com.ishi.Doctor.Patient.doctor.service;

import com.ishi.Doctor.Patient.doctor.Entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();

    boolean updateDoctor(Doctor doctor, Long id);

    void addDoctor(Doctor doctor);

    boolean removeDoctor(Long id);

    Doctor getDoctorById(Long id);
}
