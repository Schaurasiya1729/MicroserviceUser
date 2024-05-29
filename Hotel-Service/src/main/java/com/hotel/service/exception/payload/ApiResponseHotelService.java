package com.hotel.service.exception.payload;

import org.springframework.http.HttpStatus;

import lombok.Data;


@Data
public class ApiResponseHotelService {
	
	private String message;
	private boolean success;
	private HttpStatus httpStatus;

}
