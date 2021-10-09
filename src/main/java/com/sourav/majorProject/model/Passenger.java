package com.sourav.majorProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Passenger {
    @Id
    private BigInteger pnrNumber;
    private String passengerName;
    private int passengerAge;
    private BigInteger passengerUIN;


    public BigInteger getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(BigInteger pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public BigInteger getPassengerUIN() {
        return passengerUIN;
    }

    public void setPassengerUIN(BigInteger passengerUIN) {
        this.passengerUIN = passengerUIN;
    }


}
