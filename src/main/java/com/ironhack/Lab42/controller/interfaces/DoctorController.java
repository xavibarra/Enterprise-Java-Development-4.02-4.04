package com.ironhack.Lab42.controller.interfaces;

import com.ironhack.Lab42.enums.Status;
import com.ironhack.Lab42.model.Doctor;

import java.util.List;

public interface DoctorController {
    List<Doctor> getAllDoctors();
    Doctor findById(Long id);

    List<Doctor> findByStatus(Status status);

    List<Doctor> findByDepartment(String department);

    void addDoctor(Doctor doctor);

}
