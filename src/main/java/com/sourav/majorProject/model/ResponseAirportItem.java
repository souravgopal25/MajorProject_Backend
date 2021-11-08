package com.sourav.majorProject.model;

import com.google.gson.annotations.SerializedName;

public class ResponseAirportItem{

	@SerializedName("city_name")
	private String cityName;

	@SerializedName("airport_name")
	private String airportName;

	@SerializedName("IATA_code")
	private String iATACode;

	@SerializedName("ICAO_code")
	private String iCAOCode;

	@Override
	public String toString() {
		return "ResponseAirportItem{" +
				"cityName='" + cityName + '\'' +
				", airportName='" + airportName + '\'' +
				", iATACode='" + iATACode + '\'' +
				", iCAOCode='" + iCAOCode + '\'' +
				'}';
	}

	public String getCityName(){
		return cityName;
	}

	public String getAirportName(){
		return airportName;
	}

	public String getIATACode(){
		return iATACode;
	}

	public String getICAOCode(){
		return iCAOCode;
	}
}