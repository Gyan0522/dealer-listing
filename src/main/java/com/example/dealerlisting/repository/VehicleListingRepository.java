package com.example.dealerlisting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dealerlisting.model.VehicleListing;

public interface VehicleListingRepository extends JpaRepository<VehicleListing, Long> {
	
	 @Query("select u from VehicleListing u where u.make =?1 and u.model =?2 and u.year =?3 and u.color = ?4")
	 List<VehicleListing> findByMake(String make, String model, Integer year, String color );

	 @Query("select u from VehicleListing u where u.dealerId =?1 and u.code =?2 ")
	 VehicleListing findBydealerIdandCode( String dealerId, String code );

}