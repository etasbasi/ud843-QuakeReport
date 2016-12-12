package com.example.android.quakereport;

/**
 * Created by Tasbasi on 10/31/2016.
 */
public class Earthquake {


    private double mMagnitude;

    private String mLocation;

    private long mTimeInMilliseconds;

    private String mUrl;

    public Earthquake(double magninute, String location, long TimeInMilliseconds, String url) {
        mMagnitude = magninute;
        mLocation = location;
        mTimeInMilliseconds = TimeInMilliseconds;
        mUrl = url;
    }


    public double getMagnitude() {return mMagnitude; }

    public String getLocation() {return mLocation; }

    public long getTimeInMilliseconds() {return mTimeInMilliseconds; }

    public String getUrl() {return mUrl; }


}
