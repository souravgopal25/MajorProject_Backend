package com.sourav.majorProject.service;

import com.sourav.majorProject.dao.FlightBookingDao;
import com.sourav.majorProject.dao.ScheduledFlightDao;
import com.sourav.majorProject.dao.UserDao;
import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.exceptions.ScheduledFlightNotFoundException;
import com.sourav.majorProject.model.BookingDetailFlight;
import com.sourav.majorProject.model.FlightBooking;
import com.sourav.majorProject.model.ScheduledFlight;
import com.sourav.majorProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    FlightBookingDao bookingDao;
    @Autowired
    ScheduledFlightDao scheduledFlightDao;
    @Autowired
    UserDao userDao;


    @Override
    @Transactional
    public ResponseEntity<FlightBooking> createBooking(BookingDetailFlight bookingDetailFlight) {
//        Optional<FlightBooking> findBookingById = bookingDao.findById(newBooking.getBookingId());
//        try {
//            if (!findBookingById.isPresent()) {
//                bookingDao.save(newBooking);
//                return new ResponseEntity<FlightBooking>(newBooking, HttpStatus.OK);
//            } else
//                throw new RecordAlreadyPresentException(
//                        "Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
//        } catch (RecordAlreadyPresentException e) {
//
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        Optional<User> user = userDao.findByUid(bookingDetailFlight.getUid());
        if (!user.isPresent()) {
            throw new RecordNotFoundException("User not present with UID" + bookingDetailFlight.getUid());
        }
        int noOfPassengers = bookingDetailFlight.getPassengersList().size();
        ScheduledFlight scheduledFlight = scheduledFlightDao.findById(bookingDetailFlight.getScheduledFlightId()).
                orElseThrow(() -> new ScheduledFlightNotFoundException("Scheduled FLight Not Found " + bookingDetailFlight.getScheduledFlightId()));
        scheduledFlight.decreaseSeats(noOfPassengers);
        FlightBooking flightBooking = new FlightBooking(bookingDetailFlight.getPassengersList(), bookingDetailFlight.getDate(), noOfPassengers, bookingDetailFlight.getMoneyCharged(), user.get(), scheduledFlight);
        FlightBooking flightBooking1 = bookingDao.save(flightBooking);
        return new ResponseEntity<FlightBooking>(flightBooking1, HttpStatus.OK);


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
