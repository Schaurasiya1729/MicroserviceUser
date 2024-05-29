package com.hotel.service.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.hotel.service.exception.payload.ApiResponseHotelService;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	//@ExceptionHandler(ResourceNotFoundException.class)
	/*
	 * If there is any exception with the name of ResourceNotFoundException then this @ExceptionHandler will
	 * handle that exception
	 */
	/*public ResponseEntity<ApiResponseHotelService> resourceNotFoundException(ResourceNotFoundException exception){

		ApiResponseHotelService apiResponse=new ApiResponseHotelService();
		
		apiResponse.setMessage(exception.getMessage());
		apiResponse.setSuccess(false);
		apiResponse.setHttpStatus(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(apiResponse);
		
	}*/
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> resourceNotFoundException(ResourceNotFoundException exception){
		
		
		Map<String,Object> map=new HashMap<>();
		map.put("Messgae", exception.getMessage());
		map.put("isSuccess", false);
		map.put("status", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);

	}

}
