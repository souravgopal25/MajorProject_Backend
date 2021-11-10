package com.sourav.majorProject.service;

import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.exceptions.ScheduledFlightNotFoundException;
import com.sourav.majorProject.model.ScheduledFlight;

import java.math.BigInteger;

public interface ScheduledFlightService {
    public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);

    public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

    public String removeScheduledFlight(String id) throws RecordNotFoundException;

    public Iterable<ScheduledFlight> viewAllScheduledFlights();

    public ScheduledFlight viewScheduledFlight(String id) throws ScheduledFlightNotFoundException;
    public Iterable<ScheduledFlight> viewScheduledFlightOnDate(String srcAirport,String destnAirport,String date) throws ScheduledFlightNotFoundException;
}
