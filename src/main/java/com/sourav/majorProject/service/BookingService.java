package com.sourav.majorProject.service;

import com.sourav.majorProject.model.BookingDetailFlight;
import com.sourav.majorProject.model.FlightBooking;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public interface BookingService {
    public ResponseEntity<FlightBooking> createBooking(BookingDetailFlight bookingDetailFlight);

    public FlightBooking updateBooking(FlightBooking newBooking);

    public String deleteBooking(BigInteger bookingId);

    public Iterable<FlightBooking> displayAllBooking();

    public ResponseEntity<?> findBookingById(BigInteger bookingId);
}
