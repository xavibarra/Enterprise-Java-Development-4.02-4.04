package com.ironhack.Lab42.controller.interfaces;

import com.ironhack.Lab42.enums.Status;
import com.ironhack.Lab42.model.Doctor;
import com.ironhack.Lab42.model.Patient;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PatientController {
    List<Patient> getAllPatients();
    Patient findById(Integer id);
    List<Patient> findByDateOfBirthBetween(LocalDate from, LocalDate to);
    List<Patient> findByAdmittedByDepartment(String department);
    List<Patient> findByAdmittedByStatus(Status status);
    void addPatient(Patient patient);

}