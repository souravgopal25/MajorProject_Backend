package com.sourav.majorProject.service;

import com.sourav.majorProject.dao.FlightBookingDao;
import com.sourav.majorProject.exceptions.RecordAlreadyPresentException;
import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.model.FlightBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    FlightBookingDao bookingDao;

    @Override
    public ResponseEntity<?> createBooking(FlightBooking newBooking) {
        Optional<FlightBooking> findBookingById = bookingDao.findById(newBooking.getBookingId());
        try {
            if (!findBookingById.isPresent()) {
                bookingDao.save(newBooking);
                return new ResponseEntity<FlightBooking>(newBooking, HttpStatus.OK);
            } else
                throw new RecordAlreadyPresentException(
                        "Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
        } catch (RecordAlreadyPresentException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public FlightBooking updateBooking(FlightBooking newBooking) {
        Optional<FlightBooking> findBookingById = bookingDao.findById(newBooking.getBookingId());
        if (findBookingById.isPresent()) {
            bookingDao.save(newBooking);
        } else
            throw new RecordNotFoundException(
                    "Booking with Booking Id: " + newBooking.getBookingId() + " not exists!!");
        return newBooking;
    }

    @Override
    public String deleteBooking(BigInteger bookingId) {
        Optional<FlightBooking> findBookingById = bookingDao.findById(bookingId);
        if (findBookingById.isPresent()) {
            bookingDao.deleteById(bookingId);
            return "Booking Deleted!!";
        } else
            throw new RecordNotFoundException("Booking not found for the entered BookingID");
    }

    @Override
    public Iterable<FlightBooking> displayAllBooking() {
        return bookingDao.findAll();
    }

    @Override
    public ResponseEntity<?> findBookingById(BigInteger bookingId) {
        Optional<FlightBooking> findById = bookingDao.findById(bookingId);
        try {
            if (findById.isPresent()) {
                FlightBooking findBooking = findById.get();
                return new ResponseEntity<FlightBooking>(findBooking, HttpStatus.OK);
            } else
                throw new RecordNotFoundException("No record found with ID " + bookingId);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
