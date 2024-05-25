package com.user.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.exception.ResourceNotFoundException;
import com.user.service.repositries.UserRepo;
import com.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public com.user.service.entities.User saveUser(com.user.service.entities.User user) {
		String randomUserUUID = UUID.randomUUID().toString();
		user.setUserId(randomUserUUID);
		return userRepo.save(user);
	}

	@Override
	public List<com.user.service.entities.User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public com.user.service.entities.User getUser(String userId) {
		return userRepo.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User not found with the id "+userId)
				);
	}

}
