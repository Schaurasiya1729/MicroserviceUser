package com.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.exception.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	/*
	 * If there is any exception with the name of ResourceNotFoundException then this @ExceptionHandler will
	 * handle that exception
	 */
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException exception){
		
		ApiResponse apiResponse=new ApiResponse();
		
		apiResponse.setMessage(exception.getMessage());
		apiResponse.setSuccess(false);
		apiResponse.setHttpStatus(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(apiResponse);
		
	}

}
