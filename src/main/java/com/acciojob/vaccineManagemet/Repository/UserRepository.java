package com.acciojob.vaccineManagemet.Repository;

import com.acciojob.vaccineManagemet.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
