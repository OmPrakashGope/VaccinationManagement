package com.acciojob.vaccineManagemet.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAndHospitalDto {
    private int doctorId;
    private int vaccinationCenterId;
}
