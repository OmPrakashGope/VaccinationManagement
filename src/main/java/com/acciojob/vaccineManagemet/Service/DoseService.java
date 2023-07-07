package com.acciojob.vaccineManagemet.Service;

import com.acciojob.vaccineManagemet.Exception.UserNotFoundException;
import com.acciojob.vaccineManagemet.Model.Dose;
import com.acciojob.vaccineManagemet.Model.User;
import com.acciojob.vaccineManagemet.Repository.DoseRepository;
import com.acciojob.vaccineManagemet.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoseService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoseRepository doseRepository;
    public void giveDose(int userId, String doseId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty())
        {
            throw new UserNotFoundException("User of given user id does not exists");
        }
        User user = userOptional.get();
        Dose dose = new Dose();
        dose.setDoseId(doseId);
        dose.setUser(user);
        user.setDose(dose);
        userRepository.save(user);
    }
}
