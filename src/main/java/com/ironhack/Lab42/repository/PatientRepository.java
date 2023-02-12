package com.ironhack.Lab42.repository;

import com.ironhack.Lab42.enums.Status;
import com.ironhack.Lab42.model.Doctor;
import com.ironhack.Lab42.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirthBetween(LocalDate from, LocalDate to);
    List<Patient> findByAdmittedByDepartment(String department);
    List<Patient> findByAdmittedByStatus(Status status);
}