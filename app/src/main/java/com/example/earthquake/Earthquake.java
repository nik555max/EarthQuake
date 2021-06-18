package com.example.earthquake;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class Earthquake {
    // @param magnitude earth quake magnitude
    private double magnitude;

    // @param city location of earthquake
    private String location;

    // @param date , the  timeInMillisecond
    private long timeInMillisecond;

    //@param url, url of the particular earthquake data
    private String url;



    public Earthquake(double magnitude, String location, long timeInMillisecond, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.timeInMillisecond = timeInMillisecond;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
//    public String getDate() {
//        //this line of code will convert unix time in millisecond to a date object
//        long timeInMilliSeconds = date;
//        Date dateObject = new Date(timeInMilliSeconds);
//
//        //this line of code will convert date object into a desired format and according to the time zone of the user
//        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
//        String dateToDisplay = dateFormatter.format(dateObject);
//
//        return dateToDisplay;
//    }

   public long getTimeInMillisecond(){
        return timeInMillisecond;
   }

    public String getUrl() {
        return url;
    }
}
