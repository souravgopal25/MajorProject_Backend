package com.sourav.majorProject.service;

import com.sourav.majorProject.dao.AirportDao;
import com.sourav.majorProject.exceptions.RecordAlreadyPresentException;
import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AirportServiceImpl implements AirportService{
    @Autowired
    AirportDao airportDao;
    @Override
    public Iterable<Airport> viewAllAirport() {
        return airportDao.findAll();
    }

    @Override
    public Airport viewAirport(String airportCode) {
        Optional<Airport> findbyId=airportDao.findById(airportCode);
        if (findbyId.isPresent()){
            return findbyId.get();
        }else{
            throw new RecordNotFoundException("Airport with airport code "+airportCode+" not exists");
        }
    }

    @Override
    public ResponseEntity<?> addAirport(Airport airport) {
        Optional<Airport> findById = airportDao.findById(airport.getAirportCode());
        try {
            if (!findById.isPresent()) {
                airportDao.save(airport);
                return new ResponseEntity<Airport>(airport, HttpStatus.OK);
            }
            else
                throw new RecordAlreadyPresentException(
                        "Airport with code : " + airport.getAirportCode() + " already present");
        }
        catch(RecordAlreadyPresentException e)
        {
            return new ResponseEntity<Airport>(airport,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Airport modifyAirport(Airport airport) {
        Optional<Airport> findById = airportDao.findById(airport.getAirportCode());
        if (findById.isPresent()) {
            airportDao.save(airport);
        }
        else
            throw new RecordNotFoundException("Airport with code: " + airport.getAirportCode() + " not exists");
        return airport;
    }

    @Override
    public String removeAirport(String airportCode) {
        Optional<Airport> findById = airportDao.findById(airportCode);
        if (findById.isPresent()) {
            airportDao.deleteById(airportCode);
            return "Airport removed";
        } else
            throw new RecordNotFoundException("Airport with code: " + airportCode + " not exists");

    }
}
