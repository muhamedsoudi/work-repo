package com.agilebis.test.assessmentDemo.service.contract;

import com.agilebis.test.assessmentDemo.model.dto.GeoCodeResponse;
import com.agilebis.test.assessmentDemo.model.dto.GeoCodeXMLResponse;

public interface IGeoCodeXMLResponseFormatter {

	/**
	 * This method tries to Parse the GEOCODE API Response and Return Well Formatted Response
	 * @param geoCodeResponse
	 * @return GeoCodeResponse
	 */
	GeoCodeResponse getFormattedResponse(GeoCodeXMLResponse geoCodeResponse);

}