package com.sourav.majorProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Flight {
    @Id
    private String flightNo;
    private String carrierName;
    private String flightModel;
    private int seatCapacity;

    public Flight(String flightNo, String carrierName, String flightModel, int seatCapacity) {
        this.flightNo = flightNo;
        this.carrierName = carrierName;
        this.flightModel = flightModel;
        this.seatCapacity = seatCapacity;
    }

    public Flight() {
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }
    @JsonIgnore
    public String getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(String flightModel) {
        this.flightModel = flightModel;
    }

   @JsonIgnore
    public int getCap(){
        return seatCapacity;
    }
    @JsonIgnore
    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Flight other = (Flight) obj;
        if (carrierName == null) {
            if (other.carrierName != null)
                return false;
        } else if (!carrierName.equals(other.carrierName))
            return false;
        if (flightModel == null) {
            if (other.flightModel != null)
                return false;
        } else if (!flightModel.equals(other.flightModel))
            return false;
        if (flightNo == null) {
            if (other.flightNo != null)
                return false;
        } else if (!flightNo.equals(other.flightNo))
            return false;
        if (seatCapacity != other.seatCapacity)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = flightNo != null ? flightNo.hashCode() : 0;
        result = 31 * result + (carrierName != null ? carrierName.hashCode() : 0);
        result = 31 * result + (flightModel != null ? flightModel.hashCode() : 0);
        result = 31 * result + seatCapacity;
        return result;
    }
}
