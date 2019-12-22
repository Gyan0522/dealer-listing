package com.example.dealerlisting.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dealerlisting.model.VehicleListing;
import com.example.dealerlisting.repository.*;
import com.example.dealerlisting.exception.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
class VehicleListingController {

	private final VehicleListingRepository repository;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	VehicleListingController(VehicleListingRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/v1/vehicle_listings")

	ResponseEntity<List<VehicleListing>> getallVehicleListings() {

		List<VehicleListing> listVehicleListing = repository.findAll();

		if (listVehicleListing.size() == 0) {
			throw new VehicleListingNotFoundException();
		}

		return ResponseEntity.ok().body(listVehicleListing);
	}

	@GetMapping("/v1/searchlisting")

	ResponseEntity<List<VehicleListing>> getallStatistics(@RequestParam(required = false) String make,
			@RequestParam(required = false) String model, @RequestParam(required = false) Integer year,
			@RequestParam(required = false) String color) {
		List<VehicleListing> listVehicleListing;
		if (make == null && model == null && year == 0 && color == null) {
			listVehicleListing = repository.findAll();
		} else {
			listVehicleListing = repository.findByMake(make, model, year, color);
		}

		if (listVehicleListing.size() == 0) {
			throw new VehicleListingNotFoundException();
		}

		return ResponseEntity.ok().body(listVehicleListing);
	}

	@PutMapping("v1/listing")
	String newVehicleListing(@RequestBody VehicleListing newVehicleListing) {
		String returnCode = null;
		String dealerId = newVehicleListing.getDealerId();
		String code = newVehicleListing.getCode();

		VehicleListing existingVehicleListing = repository.findBydealerIdandCode(dealerId, code);

		if (((VehicleListing) existingVehicleListing) != null) {

			((VehicleListing) existingVehicleListing).setMake(newVehicleListing.getMake());
			((VehicleListing) existingVehicleListing).setModel(newVehicleListing.getModel());
			((VehicleListing) existingVehicleListing).setKw(newVehicleListing.getKw());
			((VehicleListing) existingVehicleListing).setYear(newVehicleListing.getYear());
			((VehicleListing) existingVehicleListing).setColor(newVehicleListing.getColor());
			((VehicleListing) existingVehicleListing).setPrice(newVehicleListing.getPrice());

			if (repository.save(existingVehicleListing) != null) {
				returnCode = VehicleListing.updated(HttpStatus.CREATED);
			}

		} else {
			if (repository.save(newVehicleListing) != null) {
				returnCode = VehicleListing.created(HttpStatus.CREATED);
			}
		}

		return returnCode;
	}
	
}
