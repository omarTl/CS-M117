package com.example.android.bluetoothchat;

import android.content.Context;
import android.location.Location;

/**
 * Created by omart on 12/2/2017.
 */

public class Person {
    private String name;
    private Location location;

    public Person(){}
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setLocation(Location loc){
        this.location = loc;
    }
    public String getLocationString(){
        Double lat = this.location.getLatitude();
        Double lng = this.location.getLongitude();
        return lat + " " + lng;
    }
}
