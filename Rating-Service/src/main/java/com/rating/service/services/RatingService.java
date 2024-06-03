package com.rating.service.services;

import java.util.List;

import com.rating.service.entities.Rating;

public interface RatingService {
	
	//create
	Rating create(Rating rating);
	
	//get All ratings
	
	List<Rating> getAllRatings();
	
	//get all by userId
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getAllByHotelId(String hotelId);
	

}
