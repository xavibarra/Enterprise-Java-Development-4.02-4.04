package com.ironhack.Lab42.controller.imp;

import com.ironhack.Lab42.controller.interfaces.PatientController;
import com.ironhack.Lab42.enums.Status;
import com.ironhack.Lab42.model.Doctor;
import com.ironhack.Lab42.model.Patient;
import com.ironhack.Lab42.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class PatientControllerImp implements PatientController {
    @Autowired
    PatientRepository patientRepository;
    @GetMapping("/patient")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    @GetMapping("/patient/{id}")
    public Patient findById(@PathVariable(name = "id") Integer id){

        return patientRepository.findById(id).get();
    }

    @GetMapping("/patients/date/{date}")
    public List<Patient> findByDateOfBirthBetween(@RequestParam LocalDate from, @RequestParam  LocalDate to){
        return patientRepository.findByDateOfBirthBetween(from, to);
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> findByAdmittedByDepartment(@PathVariable(value="department") String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/patients/status/{status}")
    public List<Patient> findByAdmittedByStatus(@PathVariable(value="status") Status status) {
        return patientRepository.findByAdmittedByStatus(status);
    }

    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatient(@RequestBody @Valid Patient patient) {
        patientRepository.save(patient);
    }
}
