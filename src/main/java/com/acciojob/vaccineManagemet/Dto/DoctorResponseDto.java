package com.acciojob.vaccineManagemet.Dto;

import com.acciojob.vaccineManagemet.Enums.Gender;
import com.acciojob.vaccineManagemet.Model.VaccinationCenter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponseDto {
    private String name;
    private int age;
    private Gender gender;
    private String emailId;
}
