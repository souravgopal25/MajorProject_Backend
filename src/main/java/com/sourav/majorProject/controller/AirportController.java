package com.sourav.majorProject.controller;

import com.sourav.majorProject.exceptions.RecordAlreadyPresentException;
import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.model.Airport;
import com.sourav.majorProject.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airport")
@CrossOrigin(origins = "http://localhost:3000")
public class AirportController {
    @Autowired(required = true)
    AirportService airportService;
    @GetMapping("/viewAirport/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public Airport viewAirport(@PathVariable("id") String airportCode) {
        return airportService.viewAirport(airportCode);
    }

    @GetMapping("/allAirport")
    public Iterable<Airport> viewAllAirport() {
        return airportService.viewAllAirport();
    }

    @PostMapping("/addAirport")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public void addAirport(@RequestBody Airport airport) {
        airportService.addAirport(airport);
    }

    @PutMapping("/updateAirport")
    @ExceptionHandler(RecordNotFoundException.class)
    public void modifyAirport(@RequestBody Airport airport) {
        airportService.modifyAirport(airport);
    }

    @DeleteMapping("/deleteAirport/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public void removeAirport(@PathVariable("id") String airportCode) {
        airportService.removeAirport(airportCode);
    }
}
