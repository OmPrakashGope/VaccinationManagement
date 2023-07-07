package  com.acciojob.vaccineManagemet.Controllers;

import com.acciojob.vaccineManagemet.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    private DoseService doseService;
    @PutMapping("/add-dose")
    public ResponseEntity<String> giveDose(@RequestParam int userId,@RequestParam String doseId)
    {
        try {
            doseService.giveDose(userId, doseId);
            return new ResponseEntity<>("dose successfully associated with User", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
