package com.sourav.majorProject.dao;

import com.sourav.majorProject.model.Airport;
import com.sourav.majorProject.model.ScheduledFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduledFlightDao extends JpaRepository<ScheduledFlight, Integer> {
   @Query("SELECT  scheduledFlight  FROM  ScheduledFlight as scheduledFlight,Schedule as schedule WHERE scheduledFlight .schedule=schedule AND scheduledFlight.date=?3 AND schedule.srcAirport=?1 and schedule.dstnAirport=?2 and scheduledFlight.availableSeats>=?4")
   Optional<Iterable<ScheduledFlight>> findScheduledFlightByCoditions(Airport originAirport, Airport destinationAirport, String date,int count);
}
