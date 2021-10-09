package com.sourav.majorProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    private String cityCode;
    private String airportLocation;
    private String airportName;

    public City(String cityCode, String airportLocation, String airportName) {
        this.cityCode = cityCode;
        this.airportLocation = airportLocation;
        this.airportName = airportName;
    }

    public City() {
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityCode='" + cityCode + '\'' +
                ", airportLocation='" + airportLocation + '\'' +
                ", airportName='" + airportName + '\'' +
                '}';
    }
}
