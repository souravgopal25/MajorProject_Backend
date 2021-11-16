package com.sourav.majorProject.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class ScheduledFlight {
    @Id
    @SequenceGenerator(
            name = "scheduled_flight_id_sequence",
            sequenceName = "scheduled_flight_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "scheduled_flight_id_sequence")
    @Column(name = "schedule_flight_id")
    private Integer scheduleFlightId;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private Flight flight;

    @Column(name = "available_seats")
    @NotNull
    private Integer availableSeats;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Schedule schedule;
    @NotNull
    @Transient
    private int price;
    //   dd/mm/yyyy
    @Column(name = "date")
    private String date;


    /*
     * Default constructor
     */
    public ScheduledFlight() {

    }


    public Integer getScheduleFlightId() {
        return scheduleFlightId;
    }

    public void setScheduleFlightId(Integer scheduleFlightId) {
        this.scheduleFlightId = scheduleFlightId;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public ScheduledFlight(Flight flight, Integer availableSeats, Schedule schedule, String date) {
        this.scheduleFlightId = scheduleFlightId;
        this.flight = flight;
        this.availableSeats = availableSeats;
        this.schedule = schedule;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduledFlight)) return false;

        ScheduledFlight that = (ScheduledFlight) o;

        if (price != that.price) return false;
        if (!scheduleFlightId.equals(that.scheduleFlightId)) return false;
        if (!flight.equals(that.flight)) return false;
        if (!availableSeats.equals(that.availableSeats)) return false;
        if (!schedule.equals(that.schedule)) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = scheduleFlightId.hashCode();
        result = 31 * result + flight.hashCode();
        result = 31 * result + availableSeats.hashCode();
        result = 31 * result + schedule.hashCode();
        result = 31 * result + price;
        result = 31 * result + date.hashCode();
        return result;
    }

    public int getPrice() {
        int totalSeats = flight.getCap();
        float percent = availableSeats / totalSeats;
        int price1 = (int) (schedule.getMinPrice() * (1 + (1 - percent)));
        if (price1 > getSchedule().getMaxPrice()) {
            return schedule.getMaxPrice();
        } else {
            return price1;
        }

    }
    public void decreaseSeats(int n){
        availableSeats-=n;
    }



}
