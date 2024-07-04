package com.ishi.Doctor.Patient.doctor.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
public class Doctor {


    @Id
    private Long id;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "sr_no")
//    private int sr_no;

    @NotNull
    @Size(min=3,message="Name should be at least 3 characters")
    private String name;

    @NotNull
    @Size(max = 20, message = "City should be at max 20 characters")
    private String city;

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotNull
    @Min(10)
    private String phoneNumber;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    public Doctor( Long id, String name, String city,
                  String email, String phoneNumber, Speciality speciality) {
//        this.sr_no = sr_no;
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.speciality = speciality;
    }

    public Doctor() {
    }


//    public int getSr_no() {
//        return sr_no;
//    }
//
//    public void setSr_no(int sr_no) {
//        this.sr_no = sr_no;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

}
