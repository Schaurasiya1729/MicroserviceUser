package com.rating.service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	
	@PostMapping("/saveRating")
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		System.out.println("Inside controller");
		Rating savedRating = ratingService.create(rating);
		System.out.println("Inside controller");
		if(savedRating==null) {
			return new ResponseEntity<Rating>(savedRating,HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
		
	}
	
	@GetMapping("/getAllRatings")
	public ResponseEntity<List<Rating>> getAllRatings(){
		
		List<Rating> allRatings = ratingService.getAllRatings();
		
		if(allRatings==null || allRatings.isEmpty()) {
			return new ResponseEntity<List<Rating>>(allRatings,HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(allRatings);
		
	}
	@GetMapping("/getUserRating/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		
		List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
		
		if(ratingByUserId==null || ratingByUserId.isEmpty()) {
			return new ResponseEntity<List<Rating>>(ratingByUserId,HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(ratingByUserId);
		
	}
	
	@GetMapping("/getHotelRating/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		
		List<Rating> ratingByHotelId = ratingService.getAllByHotelId(hotelId);
		
		if(ratingByHotelId==null || ratingByHotelId.isEmpty()) {
			return new ResponseEntity<List<Rating>>(ratingByHotelId,HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(ratingByHotelId);
		
	}
	
	
	
	

}
