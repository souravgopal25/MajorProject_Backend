package com.sourav.majorProject.controller;

import com.sourav.majorProject.exceptions.RecordAlreadyPresentException;
import com.sourav.majorProject.exceptions.RecordNotFoundException;
import com.sourav.majorProject.model.BookingDetailFlight;
import com.sourav.majorProject.model.FlightBooking;
import com.sourav.majorProject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

    @Autowired(required= true)
    BookingService bookingService;

    @PostMapping("/createBooking")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public void   addBooking(@RequestBody BookingDetailFlight bookingDetailFlight) {
        bookingService.createBooking(bookingDetailFlight);

    }

    @GetMapping("/readAllBooking")
    public Iterable<FlightBooking> readAllBookings() {

        return bookingService.displayAllBooking();
    }

    @PutMapping("/updateBooking")
    @ExceptionHandler(RecordNotFoundException.class)
    public void modifyBooking(@RequestBody FlightBooking updateBooking) {

        bookingService.updateBooking(updateBooking);
    }

    @GetMapping("/searchBooking/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> searchBookingByID(@PathVariable("id") BigInteger bookingId) {

        return bookingService.findBookingById(bookingId);
    }

    @DeleteMapping("/deleteBooking/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public void deleteBookingByID(@PathVariable("id") BigInteger bookingId) {

        bookingService.deleteBooking(bookingId);
    }
}
