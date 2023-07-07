package com.acciojob.vaccineManagemet.Service;

import com.acciojob.vaccineManagemet.Dto.DoctorAndHospitalDto;
import com.acciojob.vaccineManagemet.Dto.UpdateDoctorInfoDto;
import com.acciojob.vaccineManagemet.Model.Doctor;
//import Exception.*;
import com.acciojob.vaccineManagemet.Model.VaccinationCenter;
import com.acciojob.vaccineManagemet.Repository.DoctorRepository;
import com.acciojob.vaccineManagemet.Repository.VaccinationCenterRepository;
import com.acciojob.vaccineManagemet.Exception.DoctorNotFoundException;
import com.acciojob.vaccineManagemet.Exception.EmailAlreadyExistException;
import com.acciojob.vaccineManagemet.Exception.VaccinationCenterMissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;
    public void addDoctor(Doctor doctor) throws  Exception{
        if(doctor.getEmailId().equals(null))
        {
            throw new DoctorNotFoundException("It is mandatory to give name of doctor");
        }
        String email = doctor.getEmailId();
        if(doctorRepository.findByEmailId(email).isPresent())
        {
            throw new EmailAlreadyExistException("Duplicate E-mail address not allowed");
        }
        doctorRepository.save(doctor);
    }

    public void associtateDoctor(DoctorAndHospitalDto doctorAndHospitalDto) throws DoctorNotFoundException, VaccinationCenterMissingException {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorAndHospitalDto.getDoctorId());
        if(doctorOptional.isEmpty())
        {
            throw new DoctorNotFoundException("Doctor of given id does not exist");
        }
        Optional<VaccinationCenter> vaccinationCenterOptional = vaccinationCenterRepository.findById(doctorAndHospitalDto.getVaccinationCenterId());
        if(vaccinationCenterOptional.isEmpty())
        {
            throw new VaccinationCenterMissingException("Vaccination Center of given given Id does not exist");
        }
        Doctor doctor = doctorOptional.get();
        VaccinationCenter vaccinationCenter = vaccinationCenterOptional.get();
        doctor.setVaccinationCenter(vaccinationCenter);
        vaccinationCenter.getDoctorList().add(doctor);
        vaccinationCenterRepository.save(vaccinationCenter);
    }

    public void updateEmail(String prevEmail, String newEmail) throws DoctorNotFoundException{
        Optional<Doctor> doctorOptional = doctorRepository.findByEmailId(prevEmail);
        if(doctorOptional.isEmpty())
        {
            throw new DoctorNotFoundException("Doctor of given email address does not exists in the list");
        }
        Doctor doctor = doctorOptional.get();
        doctor.setEmailId(newEmail);
        doctorRepository.save(doctor);
    }

    public void updateChanges(UpdateDoctorInfoDto updateDoctorInfoDto) throws DoctorNotFoundException{
        Optional<Doctor> doctorOptional = doctorRepository.findById(updateDoctorInfoDto.getId());
        if(doctorOptional.isEmpty())
        {
            throw new DoctorNotFoundException("Doctor of given email address does not exists in the list");
        }
        Doctor doctor = doctorOptional.get();
        if(updateDoctorInfoDto.getAge() > 0)doctor.setAge(updateDoctorInfoDto.getAge());
        if(!updateDoctorInfoDto.getName().equals(null))doctor.setName(updateDoctorInfoDto.getName());
        if(!updateDoctorInfoDto.getGender().equals(null))doctor.setGender(updateDoctorInfoDto.getGender());
        doctorRepository.save(doctor);
    }
}
