package com.acciojob.vaccineManagemet.Dto;

import com.acciojob.vaccineManagemet.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDoctorInfoDto {
    String name;
    Gender gender;
    int age;
    int id;
}
