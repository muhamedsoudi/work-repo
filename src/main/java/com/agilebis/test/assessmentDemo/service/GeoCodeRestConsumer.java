package com.agilebis.test.assessmentDemo.service;

import static com.agilebis.test.assessmentDemo.utility.Constants.GEOCODE_API_KEY;
import static com.agilebis.test.assessmentDemo.utility.Constants.GEOCODE_API_URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.agilebis.test.assessmentDemo.model.dto.GeoCodeResponse;
import com.agilebis.test.assessmentDemo.model.dto.GeoCodeXMLResponse;
import com.agilebis.test.assessmentDemo.service.contract.IGeoCodeRestConsumer;
import com.agilebis.test.assessmentDemo.service.contract.IGeoCodeXMLResponseFormatter;

@Service
public class GeoCodeRestConsumer implements IGeoCodeRestConsumer {
	
	@Autowired
	IGeoCodeXMLResponseFormatter formatter;
	
	@Override
	public GeoCodeResponse geoCodeConsumer(String address) {
	 RestTemplate restTemplate = new RestTemplate();
	 String URL=GEOCODE_API_URL+address+GEOCODE_API_KEY;
	 GeoCodeXMLResponse geoCodeResponse = restTemplate.getForObject(URL, GeoCodeXMLResponse.class);
	 GeoCodeResponse formattedResponse=formatter.getFormattedResponse(geoCodeResponse);
	 return formattedResponse;
	
	}
}
