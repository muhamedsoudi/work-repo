package com.agilebis.test.assessmentDemo.service;

import java.util.LinkedHashMap;
import static com.agilebis.test.assessmentDemo.utility.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agilebis.test.assessmentDemo.exception.BadResponseException;
import com.agilebis.test.assessmentDemo.model.dto.GeoCodeResponse;
import com.agilebis.test.assessmentDemo.model.dto.GeoCodeXMLResponse;
import com.agilebis.test.assessmentDemo.service.contract.IGeoCodeXMLResponseFormatter;
import com.agilebis.test.assessmentDemo.utility.GEOCODE_STATUS;
import com.agilebis.test.assessmentDemo.utility.Utility;

@Service
public class GeoCodeXMLResponseFormatter implements IGeoCodeXMLResponseFormatter {


	@Autowired
	Utility util;
	

	/**
	 * This Method tries to format GEOCODE Response to Custom Response consists of [Address, Latitude and Longitude]
	 */
	@Override
	@SuppressWarnings("unchecked")
	public GeoCodeResponse getFormattedResponse(GeoCodeXMLResponse geoCodeResponse) {
		// Getting The Status
		GEOCODE_STATUS responseStatus=geoCodeResponse.getStatus();
		if(responseStatus!=GEOCODE_STATUS.OK)
			throw new BadResponseException(responseStatus.getDescription());
		GeoCodeResponse response=new GeoCodeResponse();
		// Getting the Information Needed from The Given GeoCode API Response
		try {
			LinkedHashMap<Object, Object> result=geoCodeResponse.getResult();
			// Getting Formatted Address
			String formattedAddress=(String)result.get(FORMATTED_ADDRESS);
			 LinkedHashMap<Object, Object> resultGeometry=(LinkedHashMap<Object, Object>) result.get(GEOMETRY);
			 LinkedHashMap<Object, Object> resultLocation=(LinkedHashMap<Object, Object>) resultGeometry.get(LOCATION);
			 // Getting Latitude and Longitude
			 String latitudeStr=(String)resultLocation.get(LAT);
			 double latitude=Double.parseDouble(latitudeStr);
			 String longitudeStr=(String)resultLocation.get(LNG);
			 double longitude=Double.parseDouble(longitudeStr);
			 response.setFormattedAddress(formattedAddress);
			 response.setLatitude(latitude);
			 response.setLongitude(longitude);
		}catch (Exception e) {
			throw new BadResponseException("Failed To Load Needed Information from the Response Such that Latitude, Longitude or Formatted Address");
		}
		return response;
	}
	
}
