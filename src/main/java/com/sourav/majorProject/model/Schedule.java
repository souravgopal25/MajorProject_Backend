package com.sourav.majorProject.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "schedule")
public class Schedule {
    public Schedule(String scheduleId, Airport srcAirport, Airport dstnAirport, String deptDateTime, String arrDateTime, int minPrice, int maxPrice) {
        this.scheduleId = scheduleId;
        this.srcAirport = srcAirport;
        this.dstnAirport = dstnAirport;
        this.deptDateTime = deptDateTime;
        this.arrDateTime = arrDateTime;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Id
    private String scheduleId;

    @OneToOne(fetch = FetchType.EAGER)
    private Airport srcAirport;

    @OneToOne(fetch = FetchType.EAGER)
    private Airport dstnAirport;

    @Column(name = "departure_date")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
    private String deptDateTime;

    @Column(name = "arrival_date")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
    private String arrDateTime;
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


    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

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

    public String getDeptDateTime() {
        return deptDateTime;
    }

    public void setDeptDateTime(String deptDateTime) {
        this.deptDateTime = deptDateTime;
    }

    public String getArrDateTime() {
        return arrDateTime;
    }

    public void setArrDateTime(String arrDateTime) {
        this.arrDateTime = arrDateTime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", srcAirport=" + srcAirport +
                ", dstnAirport=" + dstnAirport +
                ", deptDateTime='" + deptDateTime + '\'' +
                ", arrDateTime='" + arrDateTime + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }

    @Override
    public int hashCode() {
        int result = scheduleId.hashCode();
        result = 31 * result + srcAirport.hashCode();
        result = 31 * result + dstnAirport.hashCode();
        result = 31 * result + deptDateTime.hashCode();
        result = 31 * result + arrDateTime.hashCode();
        result = 31 * result + minPrice;
        result = 31 * result + maxPrice;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Schedule other = (Schedule) obj;
        if (arrDateTime == null) {
            if (other.arrDateTime != null)
                return false;
        } else if (!arrDateTime.equals(other.arrDateTime))
            return false;
        if (deptDateTime == null) {
            if (other.deptDateTime != null)
                return false;
        } else if (!deptDateTime.equals(other.deptDateTime))
            return false;
        if (dstnAirport == null) {
            if (other.dstnAirport != null)
                return false;
        } else if (!dstnAirport.equals(other.dstnAirport))
            return false;
        if (scheduleId == null) {
            if (other.scheduleId != null)
                return false;
        } else if (!scheduleId.equals(other.scheduleId))
            return false;
        if (srcAirport == null) {
            if (other.srcAirport != null)
                return false;
        } else if (!srcAirport.equals(other.srcAirport))
            return false;
        return true;
    }

}
