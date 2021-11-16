package com.sourav.majorProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "schedule")
public class Schedule {
    public Schedule(String scheduleId, Airport srcAirport, Airport dstnAirport, String deptTime, String arrTime,  int minPrice, int maxPrice) {
        this.scheduleId = scheduleId;
        this.srcAirport = srcAirport;
        this.dstnAirport = dstnAirport;
        this.deptTime = deptTime;
        this.arrTime = arrTime;

        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Id
    private String scheduleId;

    @OneToOne(fetch = FetchType.EAGER)
    private Airport srcAirport;

    @OneToOne(fetch = FetchType.EAGER)
    private Airport dstnAirport;

    @Column(name = "departure_time")
    private String deptTime;

    @Column(name = "arrival_time")
    private String arrTime;

    @Column(name = "min_price")
    private int minPrice;
    @Column(name = "max_price")
    private int maxPrice;

    /*
     * Default constructor
     */
    public Schedule() {

    }

    /*
     * Parameterized constructor
     */

    @JsonIgnore
    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }
    @JsonIgnore
    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    /*
     * Getters and setters
     */

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Airport getSrcAirport() {
        return srcAirport;
    }

    public void setSrcAirport(Airport srcAirport) {
        this.srcAirport = srcAirport;
    }

    public Airport getDstnAirport() {
        return dstnAirport;
    }

    public void setDstnAirport(Airport dstnAirport) {
        this.dstnAirport = dstnAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;

        Schedule schedule = (Schedule) o;

        if (minPrice != schedule.minPrice) return false;
        if (maxPrice != schedule.maxPrice) return false;
        if (!scheduleId.equals(schedule.scheduleId)) return false;
        if (!srcAirport.equals(schedule.srcAirport)) return false;
        if (!dstnAirport.equals(schedule.dstnAirport)) return false;
        if (!deptTime.equals(schedule.deptTime)) return false;
        return arrTime.equals(schedule.arrTime);
    }

    @Override
    public int hashCode() {
        int result = scheduleId.hashCode();
        result = 31 * result + srcAirport.hashCode();
        result = 31 * result + dstnAirport.hashCode();
        result = 31 * result + deptTime.hashCode();
        result = 31 * result + arrTime.hashCode();

        result = 31 * result + minPrice;
        result = 31 * result + maxPrice;
        return result;
    }

    public String getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }


}
