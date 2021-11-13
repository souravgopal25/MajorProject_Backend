package com.sourav.majorProject.model;

import java.math.BigInteger;
import java.util.List;

public class BookingDetailFlight {
    Integer scheduledFlightId;
    String uid;
    List<Passenger> passengersList;
    Double moneyCharged;
    String date;

    public BookingDetailFlight(Integer scheduledFlightId, String uid, List<Passenger> passengersList, Double moneyCharged, String date) {
        this.scheduledFlightId = scheduledFlightId;
        this.uid = uid;
        this.passengersList = passengersList;
        this.moneyCharged = moneyCharged;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BookingDetailFlight() {
    }

    public Integer getScheduledFlightId() {
        return scheduledFlightId;
    }

    public void setScheduledFlightId(Integer scheduledFlightId) {
        this.scheduledFlightId = scheduledFlightId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<Passenger> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(List<Passenger> passengersList) {
        this.passengersList = passengersList;
    }

    public Double getMoneyCharged() {
        return moneyCharged;
    }

    public void setMoneyCharged(Double moneyCharged) {
        this.moneyCharged = moneyCharged;
    }
}
