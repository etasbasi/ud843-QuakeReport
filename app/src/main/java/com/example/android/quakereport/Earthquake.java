package com.example.android.quakereport;

/**
 * Created by Tasbasi on 10/31/2016.
 */
public class Earthquake {


    private String mMagnitude;

    private String mLocation;

    private String mDate;

    public Earthquake(String magninute, String location, String date) {
        mMagnitude = magninute;
        mLocation = location;
        mDate = date;
    }


    public String getMagnitude() {return mMagnitude; }

    public String getLocation() {return mLocation; }

    public String getDate() {return mDate; }


}
