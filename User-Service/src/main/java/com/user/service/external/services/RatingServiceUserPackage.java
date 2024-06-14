package com.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.service.entities.Rating;

@FeignClient(name="RATING-SERVICE")
@Service
public interface RatingServiceUserPackage {
	
	
	
	//POST
	@PostMapping("/ratings/saveRating")
	Rating createRating(Rating rating);
	
	//PUT
	@PutMapping("/ratings/updateRating/{ratingId}")
	Rating updateRating(@PathVariable String ratingId,Rating rating);
	
	//Delete
	@DeleteMapping("/ratings/{ratingId}")
	Rating deleteRating(@PathVariable String ratingId);
	

}
