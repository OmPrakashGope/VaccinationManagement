package com.acciojob.vaccineManagemet.Service;

import com.acciojob.vaccineManagemet.Model.Dose;
import com.acciojob.vaccineManagemet.Model.User;
import com.acciojob.vaccineManagemet.Exception.AppointementNotBookedException;
import com.acciojob.vaccineManagemet.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void addUser(User user) {
        userRepository.save(user);
    }

    public Date getVaccDate(User user) throws AppointementNotBookedException{
        Dose dose = user.getDose();
        if(dose == null)
        {
            throw new AppointementNotBookedException("not found");
        }
        return dose.getVaccinationDate();
    }

    public void updateEmail(User user,String email) {
        user.setEmail(email);
        userRepository.save(user);
    }

    public String getEmailId(User user) {
        String email = user.getEmail();
        return email;
    }
}
