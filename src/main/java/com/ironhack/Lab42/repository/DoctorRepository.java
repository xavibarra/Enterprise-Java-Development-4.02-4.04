package com.ironhack.Lab42.repository;


import com.ironhack.Lab42.enums.Status;
import com.ironhack.Lab42.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findByStatus(Status status);
    List<Doctor> findByDepartment(String department);

}
