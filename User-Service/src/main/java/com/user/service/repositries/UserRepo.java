package com.user.service.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
	

}
