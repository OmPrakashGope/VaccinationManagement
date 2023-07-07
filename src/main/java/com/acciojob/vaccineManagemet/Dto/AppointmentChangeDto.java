package com.acciojob.vaccineManagemet.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;
@Data
public class AppointmentChangeDto {
    private int appointmentId;
    private Date appointmentDate;
    private LocalTime appointmentTime;
}
