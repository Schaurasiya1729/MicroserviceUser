package com.hotel.service.services;

import java.util.List;
import com.hotel.service.entities.Hotel;

public interface HotelService{
	
	
	//create hotel
	Hotel create(Hotel hotel);
	
	//get AllHotel
	List<Hotel> getAllHotels();
	
	
	//get Single Hotel
	Hotel getHotel(String hotelId);

}
