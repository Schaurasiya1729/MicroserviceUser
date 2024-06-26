package com.hotel.service.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.service.entities.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String>{

}
