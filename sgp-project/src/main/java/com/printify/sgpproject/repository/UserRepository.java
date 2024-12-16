package com.printify.sgpproject.repository;

import com.printify.sgpproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
