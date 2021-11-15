package com.sourav.majorProject.config;

import com.google.gson.Gson;
import com.sourav.majorProject.dao.AirportDao;
import com.sourav.majorProject.dao.FlightDao;
import com.sourav.majorProject.dao.ScheduleDao;
import com.sourav.majorProject.dao.ScheduledFlightDao;
import com.sourav.majorProject.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class AirportConfig {
    public ResponseAirportItem[] getJSON(String path) {
        File file = null;
        try {
            file = ResourceUtils.getFile(path);
            String content = new String(Files.readAllBytes(file.toPath()));
            Gson gson = new Gson();
            ResponseAirportItem[] responseAirport = gson.fromJson(new FileReader(path), ResponseAirportItem[].class);
            System.out.println(responseAirport[0].toString());
            return responseAirport;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    CommandLineRunner commandLineRunner(ScheduleDao scheduleDao, AirportDao airportDao, FlightDao flightDao, ScheduledFlightDao scheduledFlightDao) {
        return args -> {
//            ResponseAirportItem[] responseAirportItems = getJSON("src/main/resources/json/airports.json");
//            List<Airport> list = new ArrayList<>();
//            for (ResponseAirportItem obj : responseAirportItems) {
//                Airport airport = new Airport(obj.getIATACode(), obj.getCityName(), obj.getAirportName());
//                list.add(airport);
//            }
//            airportDao.saveAll(list);
//           Flight flight=new Flight("6E525","Indigo","A320",180);
//            flightDao.save(flight);
//            Airport airport=airportDao.getById("IXA");
//            Airport airport1=airportDao.getById("AGX");
//            Schedule schedule=new Schedule("6E525",airport,airport1,"05:00","09:00",5000,7500);
//
//            ScheduledFlight scheduledFlight1 = new ScheduledFlight(flight, flight.getSeatCapacity(), schedule, "30/11/2021");
//            scheduledFlightDao.save(scheduledFlight1);
//              BookingDetailFlight bookingDetailFlight=new BookingDetailFlight();
//              bookingDetailFlight.setDate("13/11/2021");
//              bookingDetailFlight.setMoneyCharged(5000.00);
//              bookingDetailFlight.setScheduledFlightId(8);
//              bookingDetailFlight.setUid("0074d6ac-59f3-3e11-a8a0-dba54390c830");
//              Passenger passenger=new Passenger();
//              passenger.setPassengerAge(25);
//              passenger.setPassengerName("Sourav");
//              passenger.setPassengerUIN("ZXAdasfasdf");
//              bookingDetailFlight.setPassengersList(Arrays.asList(passenger));
            //   System.out.println(new Gson().toJson(bookingDetailFlight,BookingDetailFlight.class));


        };
    }


}
