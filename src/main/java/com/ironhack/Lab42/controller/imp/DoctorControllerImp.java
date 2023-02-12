package com.ironhack.Lab42.controller.imp;

import com.ironhack.Lab42.controller.dto.DoctorDepartmentDTO;
import com.ironhack.Lab42.controller.dto.DoctorStatusDTO;
import com.ironhack.Lab42.controller.interfaces.DoctorController;
import com.ironhack.Lab42.enums.Status;
import com.ironhack.Lab42.model.Doctor;
import com.ironhack.Lab42.repository.DoctorRepository;
import com.ironhack.Lab42.service.interfaces.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorControllerImp implements DoctorController {
    private DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    public Doctor findById(@PathVariable(name = "id") Long id){
        return doctorRepository.findById(id).get();
    }

    @GetMapping("/doctors/status/{status}")
    public List<Doctor> findByStatus(@PathVariable(name = "status") Status status){
        return doctorRepository.findByStatus(status);
    }

    @GetMapping("/doctors/department/{department}")
    public List<Doctor> findByDepartment(@PathVariable(name = "department") String department){
        return doctorRepository.findByDepartment(department);
    }

    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDoctor(@RequestBody @Valid Doctor doctor) {
        doctorRepository.save(doctor);
    }


    @PatchMapping("/doctors/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Long id, @RequestBody DoctorStatusDTO doctor) {
        doctorService.updateDoctorStatus(id, doctor);
    }
    @PatchMapping("/doctors/{id}/department")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment(@PathVariable Long id, @RequestBody DoctorDepartmentDTO doctor) {
        doctorService.updateDoctorDepartment(id, doctor);
    }
}
