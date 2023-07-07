package com.acciojob.vaccineManagemet.Service;

import com.acciojob.vaccineManagemet.Dto.DoctorResponseDto;
import com.acciojob.vaccineManagemet.Dto.AddVaccinationCenterDto;
import com.acciojob.vaccineManagemet.Dto.AssociateDoctorCenterDto;
import com.acciojob.vaccineManagemet.Enums.Gender;
import com.acciojob.vaccineManagemet.Exception.CenterNotFoundException;
import com.acciojob.vaccineManagemet.Exception.DoctorNotFoundException;
import com.acciojob.vaccineManagemet.Exception.VaccinationCenterMissingException;
import com.acciojob.vaccineManagemet.Model.Doctor;
import com.acciojob.vaccineManagemet.Model.VaccinationCenter;
import com.acciojob.vaccineManagemet.Repository.DoctorRepository;
import com.acciojob.vaccineManagemet.Repository.VaccinationCenterRepository;
import com.acciojob.vaccineManagemet.Transformer.DoctorTransformer;
import com.acciojob.vaccineManagemet.Transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinationCenterService {
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public void addVaccinationCenter(AddVaccinationCenterDto addVaccinationCenterDto) {
        VaccinationCenter vaccinationCenter = VaccinationCenterTransformer.vaccinationCenterToEntity(addVaccinationCenterDto);
        vaccinationCenterRepository.save(vaccinationCenter);
    }

    public void associateDoctorWithCenter(AssociateDoctorCenterDto associateDoctorCenterDto) throws DoctorNotFoundException,CenterNotFoundException{
        Optional<Doctor> doctorOptional = doctorRepository.findById(associateDoctorCenterDto.getDoctorId());
        if(doctorOptional.isEmpty())
        {
            throw new DoctorNotFoundException("Doctor does not exist of given id");
        }
        Doctor doctor = doctorOptional.get();
        Optional<VaccinationCenter> vaccinationCenterOptional = vaccinationCenterRepository.findById(associateDoctorCenterDto.getCenterId());
        if(vaccinationCenterOptional.isEmpty())
        {
            throw new CenterNotFoundException("Center of given name does not exist");
        }
        VaccinationCenter vaccinationCenter = vaccinationCenterOptional.get();
        vaccinationCenter.getDoctorList().add(doctor);
        doctor.setVaccinationCenter(vaccinationCenter);
        vaccinationCenterRepository.save(vaccinationCenter);
    }

    public List<DoctorResponseDto> getAllDoctorsFromCenter(int centerId) throws VaccinationCenterMissingException{
       Optional<VaccinationCenter> vaccinationCenterOptional = vaccinationCenterRepository.findById(centerId);
       if(vaccinationCenterOptional.isEmpty())
       {
           throw new VaccinationCenterMissingException("Center of given id does not exist");
       }
       VaccinationCenter vaccinationCenter = vaccinationCenterOptional.get();
       List<Doctor> doctorList = vaccinationCenter.getDoctorList();
       List<DoctorResponseDto> doctors = new ArrayList<>();
       for(Doctor doctor : doctorList)
       {
           DoctorResponseDto doctorResponseDto = DoctorTransformer.DoctorToDtEntity(doctor);
           doctors.add(doctorResponseDto);
       }
       return doctors;
    }

    public List<DoctorResponseDto> getAllMaleDoctorsFromCenter(int centerId) throws VaccinationCenterMissingException {
        Optional<VaccinationCenter> vaccinationCenterOptional = vaccinationCenterRepository.findById(centerId);
        if(vaccinationCenterOptional.isEmpty())
        {
            throw new VaccinationCenterMissingException("Center of given id does not exist");
        }
        VaccinationCenter vaccinationCenter = vaccinationCenterOptional.get();
        List<Doctor> doctorList = vaccinationCenter.getDoctorList();
        List<DoctorResponseDto> doctors = new ArrayList<>();
        for(Doctor doctor : doctorList)
        {
            if(doctor.getGender().equals(Gender.MALE)) {
                DoctorResponseDto doctorResponseDto = DoctorTransformer.DoctorToDtEntity(doctor);
                doctors.add(doctorResponseDto);
            }
        }
        return doctors;
    }

    public List<DoctorResponseDto> getAllFemaleDoctorsFromCenter(int centerId) throws VaccinationCenterMissingException {
        Optional<VaccinationCenter> vaccinationCenterOptional = vaccinationCenterRepository.findById(centerId);
        if(vaccinationCenterOptional.isEmpty())
        {
            throw new VaccinationCenterMissingException("Center of given id does not exist");
        }
        VaccinationCenter vaccinationCenter = vaccinationCenterOptional.get();
        List<Doctor> doctorList = vaccinationCenter.getDoctorList();
        List<DoctorResponseDto> doctors = new ArrayList<>();
        for(Doctor doctor : doctorList)
        {
            if(doctor.getGender().equals(Gender.FEMALE)) {
                DoctorResponseDto doctorResponseDto = DoctorTransformer.DoctorToDtEntity(doctor);
                doctors.add(doctorResponseDto);
            }
        }
        return doctors;
    }
}
