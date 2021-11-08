package com.sourav.majorProject.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @Column(name = "schedule_Id")
    private BigInteger scheduleId;

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
    @Column(name="price")
    private int price;

    /*
     * Default constructor
     */
    public Schedule() {

    }

    /*
     * Parameterized constructor
     */
    public Schedule(BigInteger scheduleId, Airport srcAirport, Airport dstnAirport,
                    String deptDateTime, String arrDateTime,int price) {
        super();
        this.scheduleId = scheduleId;
        this.srcAirport = srcAirport;
        this.dstnAirport = dstnAirport;
        this.deptDateTime = deptDateTime;
        this.arrDateTime = arrDateTime;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /*
     * Getters and setters
     */
    public BigInteger getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(BigInteger scheduleId) {
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
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        int result = scheduleId != null ? scheduleId.hashCode() : 0;
        result = 31 * result + (srcAirport != null ? srcAirport.hashCode() : 0);
        result = 31 * result + (dstnAirport != null ? dstnAirport.hashCode() : 0);
        result = 31 * result + (deptDateTime != null ? deptDateTime.hashCode() : 0);
        result = 31 * result + (arrDateTime != null ? arrDateTime.hashCode() : 0);
        result = 31 * result + price;
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
