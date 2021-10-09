package com.sourav.majorProject.dao;

import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.sourav.majorProject.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FlightBookingDao extends JpaRepository<FlightBooking, BigInteger> {
}
