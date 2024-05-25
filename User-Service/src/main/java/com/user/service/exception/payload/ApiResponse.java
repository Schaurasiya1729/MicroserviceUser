package com.user.service.exception.payload;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.Setter;

@Data
public class ApiResponse {
	
	private String message;
	private boolean success;
	private HttpStatus httpStatus;

}
