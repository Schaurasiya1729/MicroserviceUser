package com.hotel.service;

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

import com.hotel.service.entities.Hotel;
import com.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	public HotelService hotelService;
	
	@PostMapping("/createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		Hotel create = hotelService.create(hotel);
		if(create==null) {
			return new ResponseEntity<Hotel>(create,HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(create);
		
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable("hotelId") String hotelId){
		
		Hotel hotel = hotelService.getHotel(hotelId);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
		
	}
	@GetMapping("/getAllHotel")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		
		List<Hotel> allHotels = hotelService.getAllHotels();
		
		return new ResponseEntity<List<Hotel>>(allHotels,HttpStatus.OK);
	}
	
}
