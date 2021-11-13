package com.sourav.majorProject.service;

import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.exceptions.ScheduledFlightNotFoundException;
import com.sourav.majorProject.model.ScheduledFlight;

import java.math.BigInteger;

public interface ScheduledFlightService {
    public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);

    public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

    public String removeScheduledFlight(Integer id) throws RecordNotFoundException;

    public Iterable<ScheduledFlight> viewAllScheduledFlights();

    public ScheduledFlight viewScheduledFlight(Integer id) throws ScheduledFlightNotFoundException;
    public Iterable<ScheduledFlight> viewScheduledFlightOnDate(String srcAirport,String destnAirport,String date,int pax) throws ScheduledFlightNotFoundException;
}
