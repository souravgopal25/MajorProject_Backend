package com.sourav.majorProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
public class FlightBooking {
    @Id
    @SequenceGenerator(
            name = "bookingIdGen",
            sequenceName = "bookingIdGen",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdGen")
    private BigInteger bookingId;
    @OneToMany(cascade = CascadeType.ALL)
    List<Passenger> passengers;
    @NotNull
    private String bookingDate;
    @NotNull
    private int noOfPassengers;
    @NotNull
    private Double amount;
    @ManyToOne
    User user;
    @ManyToOne
    ScheduledFlight scheduledFlight;

    public FlightBooking(List<Passenger> passengers, String bookingDate, int noOfPassengers, Double amount, User user, ScheduledFlight scheduledFlight) {

        this.passengers = passengers;
        this.bookingDate = bookingDate;
        this.noOfPassengers = noOfPassengers;
        this.amount = amount;
        this.user = user;
        this.scheduledFlight = scheduledFlight;
    }
    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ScheduledFlight getScheduledFlight() {
        return scheduledFlight;
    }

    public void setScheduledFlight(ScheduledFlight scheduledFlight) {
        this.scheduledFlight = scheduledFlight;
    }

    public FlightBooking() {

    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BigInteger getBookingId() {
        return bookingId;
    }

    public void setBookingId(BigInteger bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }
}
