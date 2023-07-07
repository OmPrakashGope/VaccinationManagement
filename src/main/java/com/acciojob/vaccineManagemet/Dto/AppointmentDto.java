package com.acciojob.vaccineManagemet.Dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentDto {
    private int doctorId;
    private int userId;
    private Date appointmentDate;
    private LocalTime appointmentTime;
}
