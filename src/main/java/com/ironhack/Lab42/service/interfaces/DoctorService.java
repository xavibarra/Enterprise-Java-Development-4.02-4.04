package com.ironhack.Lab42.service.interfaces;

import com.ironhack.Lab42.controller.dto.DoctorDepartmentDTO;
import com.ironhack.Lab42.controller.dto.DoctorStatusDTO;
import com.ironhack.Lab42.enums.Status;
import com.ironhack.Lab42.model.Doctor;
import java.util.List;

public interface DoctorService {

    Doctor findById(Long id);

    List<Doctor> findByStatus(Status status);
    List<Doctor> findByDepartment(String department);



    void updateDoctorStatus(Long id, DoctorStatusDTO doctorStatusDTO);

    void updateDoctorDepartment(Long id, DoctorDepartmentDTO doctorDepartmentDTO);

}
