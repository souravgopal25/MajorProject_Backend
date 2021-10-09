package com.sourav.majorProject.dao;


import com.sourav.majorProject.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportDao extends JpaRepository<Airport,String> {
}
