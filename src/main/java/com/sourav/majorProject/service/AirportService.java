package com.sourav.majorProject.service;

import com.sourav.majorProject.model.Airport;
import org.springframework.http.ResponseEntity;

public interface AirportService {
    public Iterable<Airport> viewAllAirport();

    public Airport viewAirport(String airportCode);

    public ResponseEntity<?> addAirport(Airport airport);

    public Airport modifyAirport(Airport airport);

    public String removeAirport(String airportCode);
}
