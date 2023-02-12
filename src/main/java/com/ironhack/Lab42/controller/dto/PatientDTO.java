package com.ironhack.Lab42.controller.dto;

import com.ironhack.Lab42.model.Doctor;

import java.time.LocalDate;

public class PatientDTO {
    private String name;

    private LocalDate dateOfBirth;
    private Doctor doctor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
