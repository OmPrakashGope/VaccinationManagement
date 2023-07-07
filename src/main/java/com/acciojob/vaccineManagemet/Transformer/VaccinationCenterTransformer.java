package com.acciojob.vaccineManagemet.Transformer;

import com.acciojob.vaccineManagemet.Dto.AddVaccinationCenterDto;
import com.acciojob.vaccineManagemet.Model.VaccinationCenter;
import lombok.Data;

public class VaccinationCenterTransformer {
    public static VaccinationCenter vaccinationCenterToEntity(AddVaccinationCenterDto addVaccinationCenterDto)
    {
        VaccinationCenter vaccinationCenter = VaccinationCenter.builder().centreName(addVaccinationCenterDto.getCentreName()).
                address(addVaccinationCenterDto.getAddress()).openingTime(addVaccinationCenterDto.getOpeningTime()).
                closingTime(addVaccinationCenterDto.getClosingTime()).doseCapacity(addVaccinationCenterDto.getDoseCapacity()).
                build();
        return vaccinationCenter;
    }
}
