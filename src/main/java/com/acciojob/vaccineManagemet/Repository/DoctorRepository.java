package com.acciojob.vaccineManagemet.Repository;

import com.acciojob.vaccineManagemet.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    public Optional<Doctor> findByEmailId(String email);
}
