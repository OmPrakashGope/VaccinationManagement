package com.acciojob.vaccineManagemet.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "dose")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private Date vaccinationDate;
    @Column(unique = true)
    private String doseId;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;

}
