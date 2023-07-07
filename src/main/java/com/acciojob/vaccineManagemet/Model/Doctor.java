package com.acciojob.vaccineManagemet.Model;

import com.acciojob.vaccineManagemet.Enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docId;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    private String emailId;
    @ManyToOne
    @JoinColumn
    private VaccinationCenter vaccinationCenter;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<Appointment> appointmentList = new ArrayList<>();
}
