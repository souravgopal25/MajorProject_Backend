package com.sourav.majorProject.dao;

import com.sourav.majorProject.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, String> {
}
