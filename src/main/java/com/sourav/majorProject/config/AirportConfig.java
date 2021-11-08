package com.sourav.majorProject.config;

import com.cedarsoftware.util.io.JsonReader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.sourav.majorProject.dao.AirportDao;
import com.sourav.majorProject.model.Airport;
import com.sourav.majorProject.model.ResponseAirport;
import com.sourav.majorProject.model.ResponseAirportItem;
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
    CommandLineRunner commandLineRunner(AirportDao airportDao) {
        return args -> {
            //    Airport airport = new Airport("IXA", "Agartala", "Singerbhil Airport");
            ResponseAirportItem[] responseAirportItems = getJSON("src/main/resources/json/airports.json");
            List<Airport> list = new ArrayList<>();
            for (ResponseAirportItem obj : responseAirportItems) {
                Airport airport = new Airport(obj.getIATACode(), obj.getCityName(), obj.getAirportName());
                list.add(airport);
            }
            airportDao.saveAll(list);

        };
    }


}
