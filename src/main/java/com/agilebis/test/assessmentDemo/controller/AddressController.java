package com.agilebis.test.assessmentDemo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.agilebis.test.assessmentDemo.model.dto.ClassicResponse;
import com.agilebis.test.assessmentDemo.model.dto.GeoCodeResponse;
import com.agilebis.test.assessmentDemo.service.contract.IGeoCodeRestConsumer;

@RestController
@RequestMapping("api")
public class AddressController {

	private Log log = LogFactory.getLog(AddressController.class);

	@Autowired
	IGeoCodeRestConsumer cosumer;

	@RequestMapping("/address")
	public ResponseEntity<Object> getAddress(@RequestParam(name = "address") String address) {

		GeoCodeResponse response = null;
		try {
			response = cosumer.geoCodeConsumer(address);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error: " + e.getMessage());
			ClassicResponse classic = new ClassicResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
														  "Failure: " + e.getMessage());
			return new ResponseEntity<>(classic, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
