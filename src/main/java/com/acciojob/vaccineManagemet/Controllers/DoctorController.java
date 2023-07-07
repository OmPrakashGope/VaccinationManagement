package  com.acciojob.vaccineManagemet.Controllers;

import com.acciojob.vaccineManagemet.Dto.DoctorAndHospitalDto;
import com.acciojob.vaccineManagemet.Dto.UpdateDoctorInfoDto;
import com.acciojob.vaccineManagemet.Model.Doctor;
import com.acciojob.vaccineManagemet.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
  @Autowired
  private DoctorService doctorService;
  @PostMapping("/add-doctor")
  public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor)
  {
    try {
      doctorService.addDoctor(doctor);
      return new ResponseEntity<>("Doctor added to the list", HttpStatus.CREATED);
    }catch(Exception e)
    {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
  }
  @PutMapping("/associate/doctor/hospital")
  public ResponseEntity<String> associateDoctor(DoctorAndHospitalDto doctorAndHospitalDto)
  {
    try
    {
      doctorService.associtateDoctor(doctorAndHospitalDto);
      return new ResponseEntity<>("Given doctor associated with given vaccination center",HttpStatus.OK );
    }
    catch (Exception e)
    {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
  }
  @PutMapping("update-email")
  public ResponseEntity<String> updateEmail(@RequestParam String prevEmail,@RequestParam String newEmail)
  {
    try
    {
      doctorService.updateEmail(prevEmail,newEmail);
      return new ResponseEntity<>("Email updated to new Email " + newEmail,HttpStatus.OK);
    }catch(Exception e)
    {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
  }
  @PutMapping("update-changes")
  public ResponseEntity<String> updateChanges(@RequestBody UpdateDoctorInfoDto updateDoctorInfoDto)
  {
    try
    {
      doctorService.updateChanges(updateDoctorInfoDto);
      return new ResponseEntity<>("given information changed ",HttpStatus.OK);
    }catch(Exception e)
    {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
  }
}
