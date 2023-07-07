package com.acciojob.vaccineManagemet.Controllers;

import com.acciojob.vaccineManagemet.Dto.AddVaccinationCenterDto;
import com.acciojob.vaccineManagemet.Dto.AssociateDoctorCenterDto;
import com.acciojob.vaccineManagemet.Dto.DoctorResponseDto;
import com.acciojob.vaccineManagemet.Model.Doctor;
import com.acciojob.vaccineManagemet.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccination")
public class VaccinationCenterController {
    @Autowired
    private VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add-Vaccination-center")
    public ResponseEntity<String> addVaccinationCenter(@RequestBody AddVaccinationCenterDto addVaccinationCenterDto)
    {
        vaccinationCenterService.addVaccinationCenter(addVaccinationCenterDto);
        return new ResponseEntity<>("Vaccination center added to the list", HttpStatus.CREATED);
    }
    @PutMapping("/associate-doctor-center")
    public ResponseEntity<String> associateDoctorWithCenter(@RequestBody AssociateDoctorCenterDto associateDoctorCenterDto)
    {
        try {
            vaccinationCenterService.associateDoctorWithCenter(associateDoctorCenterDto);
            return new ResponseEntity<>("Doctor associated with doctor", HttpStatus.CREATED);
        }catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-doctors-center")
    public ResponseEntity<?> getAllDoctorsFromCenter(@RequestParam int centerId)
    {
        try
        {
            List<DoctorResponseDto> doctorList = vaccinationCenterService.getAllDoctorsFromCenter(centerId);
            return new ResponseEntity<>(doctorList,HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/male-doctors-center")
    public ResponseEntity<?> getAllMaleDoctorsFromCenter(@RequestParam int centerId)
    {
        try
        {
            List<DoctorResponseDto> doctorList = vaccinationCenterService.getAllMaleDoctorsFromCenter(centerId);
            return new ResponseEntity<>(doctorList,HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/female-doctors-center")
    public ResponseEntity<?> getAllFemaleDoctorsFromCenter(@RequestParam int centerId)
    {
        try
        {
            List<DoctorResponseDto> doctorList = vaccinationCenterService.getAllFemaleDoctorsFromCenter(centerId);
            return new ResponseEntity<>(doctorList,HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
