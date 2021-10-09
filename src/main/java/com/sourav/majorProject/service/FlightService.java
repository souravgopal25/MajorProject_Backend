package com.sourav.majorProject.service;

import com.sourav.majorProject.model.Flight;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public interface FlightService {
    public ResponseEntity<?> addFlight(Flight flight);

    public Iterable<Flight> viewAllFlight();

    public Flight viewFlight(BigInteger flightNumber);

    public Flight modifyFlight(Flight flight);

    public String removeFlight(BigInteger flightNumber);
}
