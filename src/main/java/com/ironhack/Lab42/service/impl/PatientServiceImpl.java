package com.ironhack.Lab42.service.impl;

import com.ironhack.Lab42.controller.dto.PatientDTO;
import com.ironhack.Lab42.model.Patient;
import com.ironhack.Lab42.repository.PatientRepository;
import com.ironhack.Lab42.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Override
    public void updatePatient(Integer id, Patient patient) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if(optionalPatient.isPresent()){
            patient.setId(id);
            patientRepository.save(patient);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient doesn't exist");
        }
    }
}
