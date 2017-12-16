package com.agilebis.test.assessmentDemo.utility;

public enum GEOCODE_STATUS {

	OK("successfully"),
	ZERO_RESULTS("geocode was successful but returned no results. This may occur if the geocoder was passed a non-existent address"),
	OVER_QUERY_LIMIT(" you are over your quota"),
	REQUEST_DENIED("your request was denied"),
	INVALID_REQUEST(" the query (address, components or latlng) is missing"),
	UNKNOWN_ERROR(" request could not be processed due to a server error. The request may succeed if you try again");
	private String description;
	
	private GEOCODE_STATUS(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
