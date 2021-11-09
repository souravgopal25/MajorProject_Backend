package com.sourav.majorProject.service;

import com.sourav.majorProject.dao.ScheduleDao;
import com.sourav.majorProject.dao.ScheduledFlightDao;
import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.exceptions.ScheduledFlightNotFoundException;
import com.sourav.majorProject.model.Schedule;
import com.sourav.majorProject.model.ScheduledFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService{
    @Autowired
    ScheduledFlightDao dao;

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
        updateSchedule.setArrDateTime(scheduledFlight.getSchedule().getArrDateTime());
        updateSchedule.setDeptDateTime(scheduledFlight.getSchedule().getDeptDateTime());
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
}
