package com.acciojob.vaccineManagemet.Transformer;

import com.acciojob.vaccineManagemet.Dto.AppointmentDto;
import com.acciojob.vaccineManagemet.Model.Appointment;

public class AppointmentTransformer {
    public static Appointment appointmentDtoToEntity(AppointmentDto appointmentDto)
    {
        Appointment appointment = Appointment.builder().appointmentDate(appointmentDto.getAppointmentDate()).
                appointmentTime(appointmentDto.getAppointmentTime()).build();
        return appointment;
    }
}
