package com.acciojob.vaccineManagemet.Transformer;

import com.acciojob.vaccineManagemet.Dto.DoctorResponseDto;
import com.acciojob.vaccineManagemet.Enums.Gender;
import com.acciojob.vaccineManagemet.Model.Doctor;
import com.acciojob.vaccineManagemet.Model.VaccinationCenter;
import jakarta.persistence.*;

public class DoctorTransformer {
    public static DoctorResponseDto DoctorToDtEntity(Doctor doctor)
    {
        DoctorResponseDto doctorResponseDto = DoctorResponseDto.builder().age(doctor.getAge()).gender(doctor.getGender()).
                emailId(doctor.getEmailId()).name(doctor.getName()).build();
        return  doctorResponseDto;
    }
}
