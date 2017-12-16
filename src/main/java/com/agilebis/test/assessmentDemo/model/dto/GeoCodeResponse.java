package com.agilebis.test.assessmentDemo.model.dto;

public class GeoCodeResponse {

	private String formattedAddress;
	private double latitude;
	private double longitude;

	public GeoCodeResponse() {

	}

	public GeoCodeResponse(String formattedAddress, double latitude, double longitude) {
		this.formattedAddress = formattedAddress;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeoCodeResponse [formattedAddress=").append(formattedAddress).append(", latitude=")
				.append(latitude).append(", longitude=").append(longitude).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoCodeResponse other = (GeoCodeResponse) obj;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		return true;
	}

	
	
}
