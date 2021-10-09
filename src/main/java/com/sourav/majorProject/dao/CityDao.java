package com.sourav.majorProject.dao;

import com.sourav.majorProject.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<City,Long> {
}
