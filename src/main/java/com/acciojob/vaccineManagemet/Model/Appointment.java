package com.acciojob.vaccineManagemet.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date appointmentDate;

    private LocalTime appointmentTime;

    @ManyToOne
    @JoinColumn
    private Doctor doctor;

    @ManyToOne
    @JoinColumn
    private User user;
}
