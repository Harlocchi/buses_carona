package entities.java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class bus {

    private String  name;
    private String  city;
    HourBus hourBus = new HourBus();


    public bus() {
    }

    public bus(String name, String city, HourBus hourBus) {
        this.name = name;
        this.city = city;
        this.hourBus = hourBus;
    }

    //=============GETS===============
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public HourBus getHourBus() {
        return hourBus;
    }

    //=============SETS===============


    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHourBus(HourBus hourBus) {
        this.hourBus = hourBus;
    }

    //==================METHODS=============



    public String toString() {
        HourBus hourBus = new HourBus();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        return  "name: " + getName() + "\n"
                + "city: " + getCity() + "\n"
                + "Departure Time: " + sdf.format(getHourBus().getDepartureTime()) + "h"+ "\n"
                + "Arrival Time: " + sdf.format(getHourBus().getArrivalTime())+ "h";



    }
}



