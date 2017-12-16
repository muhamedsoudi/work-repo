package com.agilebis.test.assessmentDemo.service.contract;

import com.agilebis.test.assessmentDemo.model.dto.GeoCodeResponse;

public interface IGeoCodeRestConsumer {

	GeoCodeResponse geoCodeConsumer(String address);

}