package com.agilebis.test.assessmentDemo.model.dto;

import java.util.LinkedHashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.agilebis.test.assessmentDemo.utility.GEOCODE_STATUS;

@XmlRootElement(name="GeocodeResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class GeoCodeXMLResponse {
	
	@XmlElement(name="status")
	private GEOCODE_STATUS status;
	@XmlElement(name="result")
	private LinkedHashMap<Object, Object> result;
	
	public GeoCodeXMLResponse() {
	}
	public GEOCODE_STATUS getStatus() {
		return status;
	}
	public void setStatus(GEOCODE_STATUS status) {
		this.status = status;
	}
	public LinkedHashMap<Object, Object> getResult() {
		return result;
	}
	public void setResult(LinkedHashMap<Object, Object> result) {
		this.result = result;
	}
	
	

}
