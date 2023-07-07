package com.acciojob.vaccineManagemet.Controllers;

import com.acciojob.vaccineManagemet.Dto.AppointmentChangeDto;
import com.acciojob.vaccineManagemet.Dto.AppointmentDto;
import com.acciojob.vaccineManagemet.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book-appointment")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDto appointmentDto) {
        try {
            appointmentService.bookAppointment(appointmentDto);
            return new ResponseEntity<>("Appointment booked for particular user", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/change-appointment-date")
    public ResponseEntity<String> changeAppointmentDate(@RequestBody AppointmentChangeDto appointmentChangeDto)
    {
        try{
            appointmentService.changeAppointmentDate(appointmentChangeDto);
            return new ResponseEntity<>("Appointement changed",HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
