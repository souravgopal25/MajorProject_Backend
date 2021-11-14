package com.sourav.majorProject.model;

import java.io.Serializable;

public class FlightQuery implements Serializable {
    String source;
    String destination;
    String date;
    int passenger;

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public FlightQuery() {
    }

    public FlightQuery(String source, String destination, String date,int pax) {
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.passenger =pax;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FlightQuery{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", passenger=" + passenger +
                '}';
    }
}
