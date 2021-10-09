package com.sourav.majorProject.dao;

import com.sourav.majorProject.model.ScheduledFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ScheduledFlightDao extends JpaRepository<ScheduledFlight, BigInteger> {
}
