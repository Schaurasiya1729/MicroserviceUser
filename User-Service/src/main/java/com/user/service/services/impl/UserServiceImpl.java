package com.user.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.repositries.UserRepo;
import com.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	RestTemplate restTemplate;

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
		User user = userRepo.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User not found with the id "+userId)
				);
		
		/*
		 * 
		 * Now we will call Rating serive from here using this url
		 * http://localhost:8091/ratings/getUserRating/8c3ee760-fa2e-4fc7-904f-fe6ff83ad739
		 * 
		 */
		ArrayList<Rating> forObject = restTemplate.getForObject("http://localhost:8091/ratings/getUserRating/"+user.getUserId(),
			ArrayList.class);
		System.out.println("Ratings are "+forObject);
		user.setRating(forObject);
		return user;
	}

}
