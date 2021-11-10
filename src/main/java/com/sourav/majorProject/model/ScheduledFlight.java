package com.sourav.majorProject.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class ScheduledFlight {
    @Id
    @Column(name = "schedule_flight_id")
    private String scheduleFlightId;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private Flight flight;

    @Column(name = "available_seats")
    @NotNull
    private Integer availableSeats;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;
    @NotNull
    @Transient
    private int price;


    /*
     * Default constructor
     */
    public ScheduledFlight() {

    }


    public String getScheduleFlightId() {
        return scheduleFlightId;
    }

    public void setScheduleFlightId(String scheduleFlightId) {
        this.scheduleFlightId = scheduleFlightId;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public ScheduledFlight(String scheduleFlightId, Flight flight, Integer availableSeats, Schedule schedule) {
        this.scheduleFlightId = scheduleFlightId;
        this.flight = flight;
        this.availableSeats = availableSeats;
        this.schedule = schedule;
    }

    /*
     * Getter and setter for Available seats
     */
    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    /*
     * Getter and setter for Flight object
     */
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /*
     * Getter and setter for Schedule object
     */
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "ScheduledFlight{" +
                "scheduleFlightId='" + scheduleFlightId + '\'' +
                ", flight=" + flight +
                ", availableSeats=" + availableSeats +
                ", schedule=" + schedule +
                '}';
    }

    public int getPrice() {
        int totalSeats = flight.getSeatCapacity();
        float percent = availableSeats / totalSeats;
        int price1 = (int) (schedule.getMinPrice() * (1 + (1 - percent)));
        if (price1 > getSchedule().getMaxPrice()) {
            return schedule.getMaxPrice();
        } else {
            return price1;
        }

    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int result = scheduleFlightId.hashCode();
        result = 31 * result + flight.hashCode();
        result = 31 * result + availableSeats.hashCode();
        result = 31 * result + schedule.hashCode();
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
        ScheduledFlight other = (ScheduledFlight) obj;
        if (availableSeats == null) {
            if (other.availableSeats != null)
                return false;
        } else if (!availableSeats.equals(other.availableSeats))
            return false;
        if (flight == null) {
            if (other.flight != null)
                return false;
        } else if (!flight.equals(other.flight))
            return false;
        if (schedule == null) {
            if (other.schedule != null)
                return false;
        } else if (!schedule.equals(other.schedule))
            return false;
        if (scheduleFlightId == null) {
            if (other.scheduleFlightId != null)
                return false;
        } else if (!scheduleFlightId.equals(other.scheduleFlightId))
            return false;
        return true;
    }
}
