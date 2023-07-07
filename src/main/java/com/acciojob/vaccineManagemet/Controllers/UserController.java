package  com.acciojob.vaccineManagemet.Controllers;

import com.acciojob.vaccineManagemet.Model.User;
import com.acciojob.vaccineManagemet.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody User user)
    {
        userService.addUser(user);
        return new ResponseEntity<>("user added", HttpStatus.OK);
    }

    @GetMapping("/vaccination-date")
    public ResponseEntity<String> getVaccDate(@RequestBody User user)
    {
        try{
            Date date = userService.getVaccDate(user);
        return new ResponseEntity<>("Your booking date id "+date,HttpStatus.OK);}
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-email")
    public ResponseEntity<String> updateEmail(@RequestBody User user,@RequestParam String email)
    {
        userService.updateEmail(user,email);
        return new ResponseEntity<>("E-mail changed to " + email,HttpStatus.OK);
    }
    @GetMapping("/getEmailId")
    public ResponseEntity<String> getEmailId(@RequestBody User user)
    {
        String email = userService.getEmailId(user);
        return new ResponseEntity<>("Registered E-mail id is : " + email,HttpStatus.OK);
    }
}
