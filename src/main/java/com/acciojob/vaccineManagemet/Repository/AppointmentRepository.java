package com.acciojob.vaccineManagemet.Repository;

import com.acciojob.vaccineManagemet.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
