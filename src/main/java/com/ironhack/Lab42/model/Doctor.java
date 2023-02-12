package com.ironhack.Lab42.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.Lab42.enums.Status;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
    @Id
    private Long id;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy="admittedBy")
    @JsonIgnore
    private List<Patient> patientList;
    public Doctor() {
    }

    public Doctor(String department, String name, Status status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
