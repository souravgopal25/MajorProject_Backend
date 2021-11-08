package com.sourav.majorProject.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseAirport{

	@SerializedName("ResponseAirport")
	private List<ResponseAirportItem> responseAirport;

	public List<ResponseAirportItem> getResponseAirport(){
		return responseAirport;
	}
}