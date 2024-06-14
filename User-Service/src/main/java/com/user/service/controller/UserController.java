package com.user.service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.service.entities.User;
import com.user.service.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping
	public ResponseEntity<String> getData(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("CHECKINFGDG");
	}
	
	//create user
	@PostMapping("/createUser")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		if(user==null) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
		
		return new ResponseEntity<User>(saveUser,HttpStatus.CREATED);
	}
	
	
	//all user get
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userService.getAllUser();
		
		if(allUser.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<List<User>>(allUser,HttpStatus.FOUND);
	}
	
	
	//user get
	/*
	 * 
	 * This (@PathVariable  String userId) can be used if we are keeping this @GetMapping("/{userId") same
	 * 
	 * (@PathVariable("uId")  String uId) this if we want to use different then need 
	 * to mention in @PathVariable("uId") 
	 * 
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable  String userId){
		
		User user = userService.getUser(userId);
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
		
	}

}
