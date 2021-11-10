package com.sourav.majorProject.service;

import com.sourav.majorProject.dao.AirportDao;
import com.sourav.majorProject.dao.ScheduleDao;
import com.sourav.majorProject.dao.ScheduledFlightDao;
import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.exceptions.ScheduledFlightNotFoundException;
import com.sourav.majorProject.model.Airport;
import com.sourav.majorProject.model.Schedule;
import com.sourav.majorProject.model.ScheduledFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService{
    @Autowired
    ScheduledFlightDao dao;
    @Autowired
    AirportDao airportDao;
    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    BookingService bookingService;

    @Override
    public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
        return dao.save(scheduledFlight);
    }

    @Override
    public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) {
        ScheduledFlight updateScheduleFlight = dao.findById(scheduledFlight.getScheduleFlightId()).get();
        Schedule updateSchedule = scheduleDao.findById(scheduledFlight.getSchedule().getScheduleId()).get();
        updateScheduleFlight.setAvailableSeats(scheduledFlight.getAvailableSeats());
        updateSchedule.setSrcAirport(scheduledFlight.getSchedule().getSrcAirport());
        updateSchedule.setDstnAirport(scheduledFlight.getSchedule().getDstnAirport());
        updateSchedule.setArrTime(scheduledFlight.getSchedule().getArrTime());
        updateSchedule.setDeptTime(scheduledFlight.getSchedule().getDeptTime());
        updateSchedule.setDate(scheduledFlight.getSchedule().getDate());
        dao.save(updateScheduleFlight);
        return scheduledFlight;
    }

    @Override
    public String removeScheduledFlight(String id) throws RecordNotFoundException {
        if (id == null)
            throw new RecordNotFoundException("Enter flight Id");
        Optional<ScheduledFlight> scheduleFlight = dao.findById(id);
        if (!scheduleFlight.isPresent())
            throw new RecordNotFoundException("Enter a valid Flight Id");
        else {
            dao.deleteById(id);
        }
        return "Scheduled flight with ID " + id + " is not found";
    }

    @Override
    public Iterable<ScheduledFlight> viewAllScheduledFlights() {
        return dao.findAll();
    }

    @Override
    public ScheduledFlight viewScheduledFlight(String id) throws ScheduledFlightNotFoundException {
        if (id == null)
            throw new ScheduledFlightNotFoundException("Enter flight Id");
        Optional<ScheduledFlight> scheduleFlight = dao.findById(id);
        if (!scheduleFlight.isPresent())
            throw new ScheduledFlightNotFoundException("Enter a valid Flight Id");
        else
            return scheduleFlight.get();
    }

    @Override
    public Iterable<ScheduledFlight> viewScheduledFlightOnDate(String srcAirport, String destnAirport, String date) throws ScheduledFlightNotFoundException {
        Airport source=airportDao.getById(srcAirport);
        Airport dest=airportDao.getById(destnAirport);
       Optional<Iterable<ScheduledFlight>> scheduledFlights=dao.findScheduledFlightByCoditions(source,dest,date);
       if (!scheduledFlights.isPresent()){
           throw new  ScheduledFlightNotFoundException("No Scheduled Flight");
       }else
           return scheduledFlights.get();
    }

}
