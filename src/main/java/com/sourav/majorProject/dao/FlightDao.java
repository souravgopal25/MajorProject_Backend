package com.sourav.majorProject.dao;

import com.sourav.majorProject.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FlightDao extends JpaRepository<Flight, String> {
}
