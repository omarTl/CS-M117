package com.example.android.bluetoothchat;

import android.content.Context;
import android.location.Location;

/**
 * Created by omart on 12/2/2017.
 */

public class Person {
    private String mName;
    private String mAge;
    private String mHelp;
    private String mCondition;
    private Double mLat;
    private Double mLong;

    public Person(){}

    public void setName(String name){
        this.mName = name;
    }
    public String getName(){
        return this.mName;
    }

    public void setAge(String mAge) {
        this.mAge = mAge;
    }
    public String getAge() {
        return mAge;
    }

    public void setHelp(String mHelp) {
        this.mHelp = mHelp;
    }
    public String getHelp() {
        return mHelp;
    }

    public void setCondition(String mCondition) {
        this.mCondition = mCondition;
    }
    public String getCondition() {
        return mCondition;
    }

    public void setLocation(Location loc) {
        this.mLat = loc.getLatitude();
        this.mLong = loc.getLongitude();
    }
    public void setLocation(Double latitude, Double longitude) {
        this.mLat = latitude;
        this.mLong = longitude;
    }
    public Double getLat() {return this.mLat;}
    public Double getLong() {return this.mLong;}

    public String getLocationAsString(){
        return this.mLat + " " + this.mLong;
    }
    public String getInformation(){
        return this.mName.replaceAll(" ", "_") + " "
                + this.mAge + " "
                + this.mCondition.replaceAll(" ", "_") + " "
                + this.mHelp.replaceAll(" ", "_") + " "
                + this.mLat + " "
                + this.mLong;
    }
    public void parseInformation(String message){
        final String[] inputs = message.split(" ");
        setName(inputs[0].replaceAll("_", " "));
        setAge(inputs[1].replaceAll("_", " "));
        setCondition(inputs[2].replaceAll("_", " "));
        setHelp(inputs[3].replaceAll("_", " "));
        setLocation(Double.parseDouble(inputs[4]), Double.parseDouble(inputs[5]));
    }
}
