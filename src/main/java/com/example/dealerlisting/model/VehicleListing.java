package com.example.dealerlisting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Entity
public class VehicleListing {

	private @Id @GeneratedValue Long id;
	
	
	private String dealerId;
	private String code;
	private String make;
	private String model;
	private Integer kW;
	private Integer year;

	/**
	 * @return the dealerId
	 */
	public String getDealerId() {
		return dealerId;
	}

	/**
	 * @param dealerId the dealerId to set
	 */
	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the kW
	 */
	public Integer getKw() {
		return kW;
	}

	/**
	 * @param kW the kW to set
	 */
	public void setKw(Integer kW) {
		this.kW = kW;
	}

	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	private String color;
	private Integer price;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	VehicleListing() {
	}

	/*public InstrumentTick(String string, Double string2, long string3) {
		this.instrument = string;
		this.price = string2;
		this.timestamp = string3;

	}
*/
	public static String created(HttpStatus CREATED) {
		// TODO Auto-generated method stub
		final String successCode = "201";
		return successCode;
	}

	public static String updated(HttpStatus CREATED ) {
		// TODO Auto-generated method stub
		final String successCode = "204";
		return successCode;
	}

	public ResponseEntity<VehicleListing> orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}