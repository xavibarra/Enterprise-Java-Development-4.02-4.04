package com.ironhack.Lab42.controller.dto;

import com.ironhack.Lab42.enums.Status;
import jakarta.validation.constraints.NotNull;

public class DoctorStatusDTO {
    @NotNull
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
