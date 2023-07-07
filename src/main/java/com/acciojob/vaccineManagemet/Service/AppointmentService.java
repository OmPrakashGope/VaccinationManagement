package com.acciojob.vaccineManagemet.Service;

import com.acciojob.vaccineManagemet.Dto.AppointmentChangeDto;
import com.acciojob.vaccineManagemet.Dto.AppointmentDto;
import com.acciojob.vaccineManagemet.Exception.AppointementNotBookedException;
import com.acciojob.vaccineManagemet.Exception.AppointmentNotAllowed;
import com.acciojob.vaccineManagemet.Exception.DoctorNotFoundException;
import com.acciojob.vaccineManagemet.Exception.UserNotFoundException;
import com.acciojob.vaccineManagemet.Model.Appointment;
import com.acciojob.vaccineManagemet.Model.Doctor;
import com.acciojob.vaccineManagemet.Model.User;
import com.acciojob.vaccineManagemet.Repository.AppointmentRepository;
import com.acciojob.vaccineManagemet.Repository.DoctorRepository;
import com.acciojob.vaccineManagemet.Repository.UserRepository;
import com.acciojob.vaccineManagemet.Transformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    public void bookAppointment(AppointmentDto appointmentDto) throws UserNotFoundException,DoctorNotFoundException{
        Optional<User> userOptional = userRepository.findById(appointmentDto.getUserId());
        if(userOptional.isEmpty())
        {
            throw new UserNotFoundException("User of given id does not exists");
        }
        User user = userOptional.get();
        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentDto.getDoctorId());
        if(doctorOptional.isEmpty())
        {
            throw new DoctorNotFoundException("Doctor of given id does not exists in the list");
        }
        Doctor doctor = doctorOptional.get();
        Appointment appointment = AppointmentTransformer.appointmentDtoToEntity(appointmentDto);
        appointment.setUser(user);
        appointment.setDoctor(doctor);
        appointment = appointmentRepository.save(appointment);
        doctor.getAppointmentList().add(appointment);
        user.getAppointmentList().add(appointment);
        doctorRepository.save(doctor);
        userRepository.save(user);
    }

    public void changeAppointmentDate(AppointmentChangeDto appointmentChangeDto) throws AppointementNotBookedException,AppointmentNotAllowed{
       Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentChangeDto.getAppointmentId());
       if(appointmentOptional.isEmpty())
       {
           throw new AppointementNotBookedException("Appointment by given id does not exists");
       }
       Appointment appointment = appointmentOptional.get();
       Doctor doctor = appointment.getDoctor();
        List<Appointment> appointmentList = doctor.getAppointmentList();
        for(Appointment appointment1 : appointmentList)
        {
            if(appointment1.getAppointmentDate().equals(appointmentChangeDto.getAppointmentDate()))
            {
                if(appointment1.getAppointmentTime().equals(appointmentChangeDto.getAppointmentTime()))
                {
                    throw new AppointmentNotAllowed("Appointment for given time slot is not allowed");
                }
            }
        }
        appointment.setAppointmentDate(appointmentChangeDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentChangeDto.getAppointmentTime());
        appointmentRepository.save(appointment);
    }
}
