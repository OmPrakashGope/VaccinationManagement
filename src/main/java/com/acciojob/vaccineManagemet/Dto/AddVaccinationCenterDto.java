package com.acciojob.vaccineManagemet.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddVaccinationCenterDto {
    private String centreName;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private String address;

    private int doseCapacity;
}
