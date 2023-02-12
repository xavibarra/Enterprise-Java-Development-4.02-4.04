package com.ironhack.Lab42.service.impl;

import com.ironhack.Lab42.controller.dto.DoctorDepartmentDTO;
import com.ironhack.Lab42.controller.dto.DoctorStatusDTO;
import com.ironhack.Lab42.enums.Status;
import com.ironhack.Lab42.model.Doctor;
import com.ironhack.Lab42.repository.DoctorRepository;
import com.ironhack.Lab42.service.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {


    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor findById(Long id) {
        if (doctorRepository.findById(id).isPresent()) {
            return doctorRepository.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Doctor doesn't exist");
        }

    }

    @Override
    public List<Doctor> findByStatus(Status status) {
        if (status == status.ON || status == status.OFF || status == status.ON_CALL) {
            return doctorRepository.findByStatus(status);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The status should be ON, OFF of ON_CALL");
        }

    }

    @Override
    public List<Doctor> findByDepartment(String department) {
        if (department == "orthopaedic" || department == "pulmonary" || department == "psychiatric" || department == "cardiology" || department == "immunology") {
            return doctorRepository.findByDepartment(department);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The department doesnt exist");
        }
    }

    @Override
    public void updateDoctorStatus(Long id, DoctorStatusDTO doctorStatusDTO) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (!optionalDoctor.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The doctor with that ID doent exist");
        }

        if (optionalDoctor.get().getStatus() == doctorStatusDTO.getStatus()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The doctor already has the same status");
        }

        optionalDoctor.get().setStatus(doctorStatusDTO.getStatus());
        doctorRepository.save(optionalDoctor.get());

    }

    @Override
    public void updateDoctorDepartment(Long id, DoctorDepartmentDTO doctorDepartmentDTO) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (!optionalDoctor.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The doctor with that ID doesnt exist");
        }

        if (optionalDoctor.get().getDepartment() == doctorDepartmentDTO.getDepartment()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The doctor already has the same status");
        }

        optionalDoctor.get().setDepartment(doctorDepartmentDTO.getDepartment());
        doctorRepository.save(optionalDoctor.get());

    }
}
