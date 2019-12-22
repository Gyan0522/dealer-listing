package com.example.dealerlisting.exception;

@SuppressWarnings("serial")
public class VehicleListingNotFoundException extends RuntimeException {

	public VehicleListingNotFoundException(String id) {
		super("No data found for "+id  );
	}

	public VehicleListingNotFoundException() {
		super("No data found");
	}
}