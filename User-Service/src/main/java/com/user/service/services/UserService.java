package com.user.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.service.entities.User;

@Service
public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
}
