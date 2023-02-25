package entities.java;

import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

public class HourBus {

    private Date departureTime;
    private Date arrivalTime;

    public HourBus() {
    }


    public HourBus (Date depart, Date arriv){

        this.departureTime = depart;
        this.arrivalTime = arriv;
    }


    public String toString() {

        return "departure Time: " + getDepartureTime() + "\n"
                + "arrival Time: " + getArrivalTime();


    }

    //===================GETS=======================



    public Date getArrivalTime() {
        return arrivalTime;
    }


    public Date getDepartureTime(){
        return departureTime;
    }

    //==================SETS==============================

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }




}


