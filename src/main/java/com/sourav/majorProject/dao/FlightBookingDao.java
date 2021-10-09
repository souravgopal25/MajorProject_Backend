package com.sourav.majorProject.dao;

import com.sourav.majorProject.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingDao extends JpaRepository<FlightBooking,Long> {
}
