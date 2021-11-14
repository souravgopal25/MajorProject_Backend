package com.sourav.majorProject.controller;

import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.exceptions.ScheduledFlightNotFoundException;
import com.sourav.majorProject.model.FlightQuery;
import com.sourav.majorProject.model.Schedule;
import com.sourav.majorProject.model.ScheduledFlight;
import com.sourav.majorProject.service.AirportService;
import com.sourav.majorProject.service.FlightService;
import com.sourav.majorProject.service.ScheduledFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/scheduledFlight")
@CrossOrigin(origins = "http://localhost:3000/book_flight")
public class ScheduledFlightController {
    @Autowired
    ScheduledFlightService scheduleFlightService;

    @Autowired
    AirportService airportService;

    @Autowired
    FlightService flightService;
//    @PostMapping("/add")
//    public ResponseEntity<ScheduledFlight> addSF(@ModelAttribute ScheduledFlight scheduledFlight,
//                                                 @RequestParam(name = "srcAirport") String source, @RequestParam(name = "dstnAirport") String destination,
//                                                 @RequestParam(name = "deptDateTime") String departureTime, @RequestParam(name = "arrDateTime") String arrivalTime) {
//        Schedule schedule = new Schedule();
//        schedule.setScheduleId(scheduledFlight.getScheduleFlightId());
//        try {
//            schedule.setSrcAirport(airportService.viewAirport(source));
//        } catch (RecordNotFoundException e) {
//            return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
//        }
//        try {
//            schedule.setDstnAirport(airportService.viewAirport(destination));
//        } catch (RecordNotFoundException e) {
//            return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
//        }
//        schedule.setDeptTime(departureTime);
//        schedule.setArrTime(arrivalTime);
//        try {
//            scheduledFlight.setFlight(flightService.viewFlight(scheduledFlight.getScheduleFlightId()));
//        } catch (RecordNotFoundException e1) {
//            return new ResponseEntity("Flight Not Found", HttpStatus.BAD_REQUEST);
//        }
//        scheduledFlight.setSchedule(schedule);
//        scheduledFlight.setAvailableSeats(scheduledFlight.getFlight().getSeatCapacity());
//        try {
//            return new ResponseEntity<ScheduledFlight>(scheduleFlightService.addScheduledFlight(scheduledFlight),
//                    HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity("Error adding Flight." + e, HttpStatus.BAD_REQUEST);
//        }
//    }
    @PutMapping("/modify")
    public ResponseEntity<ScheduledFlight> modifyScheduleFlight(@ModelAttribute ScheduledFlight scheduleFlight) {
        ScheduledFlight modifySFlight = scheduleFlightService.modifyScheduledFlight(scheduleFlight);
        if (modifySFlight == null) {
            return new ResponseEntity("Flight not modified", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<ScheduledFlight>(modifySFlight, HttpStatus.OK);
        }

    }
    @DeleteMapping("/delete")
    public String deleteSF(@RequestParam Integer flightId) throws RecordNotFoundException {
        return scheduleFlightService.removeScheduledFlight(flightId);
    }

    @GetMapping("/viewAll")
    public Iterable<ScheduledFlight> viewAllSF() {
        return scheduleFlightService.viewAllScheduledFlights();
    }
    @GetMapping("/search")
    public Iterable<ScheduledFlight> viewScheduledFlight(@RequestBody FlightQuery flightQuery){
        System.out.println(flightQuery.toString());

        return scheduleFlightService.viewScheduledFlightOnDate(flightQuery.getSource(),flightQuery.getDestination(), flightQuery.getDate(),flightQuery.getPassenger());
    }
}
