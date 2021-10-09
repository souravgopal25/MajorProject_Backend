package com.sourav.majorProject.dao;

import com.sourav.majorProject.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule,Long> {
}
