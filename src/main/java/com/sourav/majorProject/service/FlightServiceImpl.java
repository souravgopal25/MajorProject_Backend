package com.sourav.majorProject.service;

import com.sourav.majorProject.dao.FlightDao;
import com.sourav.majorProject.exceptions.RecordAlreadyPresentException;
import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightDao flightDao;

    @Override
    public ResponseEntity<?> addFlight(Flight flight) {
        Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
        try {
            if (!findById.isPresent()) {
                flightDao.save(flight);
                return new ResponseEntity<Flight>(flight, HttpStatus.OK);
            } else
                throw new RecordAlreadyPresentException("Flight with number: " + flight.getFlightNo() + " already present");
        }
        catch(RecordAlreadyPresentException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Iterable<Flight> viewAllFlight() {
        return flightDao.findAll();
    }

    @Override
    public Flight viewFlight(String flightNumber) {
        Optional<Flight> findById = flightDao.findById(flightNumber);
        if (findById.isPresent()) {
            return findById.get();
        }
        else
            throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");
    }

    @Override
    public Flight modifyFlight(Flight flight) {
        Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
        if (findById.isPresent()) {
            flightDao.save(flight);
        } else
            throw new RecordNotFoundException("Flight with number: " + flight.getFlightNo() + " not exists");
        return flight;
    }

    @Override
    public String removeFlight(String flightNumber) {
        Optional<Flight> findById = flightDao.findById(flightNumber);
        if (findById.isPresent()) {
            flightDao.deleteById(flightNumber);
            return "Flight removed!!";
        } else
            throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");

    }
}
