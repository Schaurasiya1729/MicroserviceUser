package com.user.service;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.user.service.entities.Rating;
import com.user.service.external.services.RatingServiceUserPackage;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	RatingServiceUserPackage ratPackage;
	
	@Test
	void createRating() {
		String userId = UUID.randomUUID().toString();
		String hotelId = UUID.randomUUID().toString();
		Rating rating=Rating.builder().rating(10).userId(userId).hotelId(hotelId).feedback("One of the best hotel").build();
		Rating createRating = ratPackage.createRating(rating);
		System.out.println("Created Rating {} "+createRating);
		
	}

}
