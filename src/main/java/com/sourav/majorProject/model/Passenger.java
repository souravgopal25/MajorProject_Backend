package com.sourav.majorProject.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Passenger {
    @Id
    @SequenceGenerator(
            name = "passengerNumber",
            sequenceName = "passengerNumber",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "passengerNumber")
    private BigInteger pnrNumber;
    private String passengerName;
    private int passengerAge;

    private String passengerUIN;


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

    public String getPassengerUIN() {
        return passengerUIN;
    }

    public void setPassengerUIN(String passengerUIN) {
        this.passengerUIN = passengerUIN;
    }


}
