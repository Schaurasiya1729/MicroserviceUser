package com.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.service.entities.Hotel;
import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.repostories.HotelRepo;
import com.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepo hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		
		String hotelId = UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		return hotelRepo.saveAndFlush(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepo.findById(hotelId).orElseThrow(
				()-> new ResourceNotFoundException("Hotel not found with the id "+hotelId)
				);
	}

}
