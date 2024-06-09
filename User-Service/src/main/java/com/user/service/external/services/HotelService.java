package com.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.user.service.entities.Hotel;

@FeignClient(name="HOTEL-SERVICE")
@Component
public interface HotelService {
	
	@GetMapping("/hotel/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);

}
