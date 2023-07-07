package com.acciojob.vaccineManagemet.Model;

import com.acciojob.vaccineManagemet.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "username")
    private String name;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(unique = true)
    private String mobileNum;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Dose dose;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Appointment> appointmentList = new ArrayList<>();
}
