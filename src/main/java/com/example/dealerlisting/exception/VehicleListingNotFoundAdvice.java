package com.example.dealerlisting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class VehicleListing {

	@ResponseBody
	@ExceptionHandler(VehicleListingNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String InstrumentNotFoundHandler(VehicleListingNotFoundException ex) {
		return ex.getMessage();
	}
}