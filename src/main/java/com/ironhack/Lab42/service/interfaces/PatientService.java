package com.ironhack.Lab42.service.interfaces;

import com.ironhack.Lab42.controller.dto.PatientDTO;
import com.ironhack.Lab42.model.Patient;

public interface PatientService {
    void updatePatient(Integer id, Patient patient);
}
