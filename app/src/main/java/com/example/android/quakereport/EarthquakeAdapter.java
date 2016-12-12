package com.example.android.quakereport;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.PatternSyntaxException;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Tasbasi on 11/1/2016.
 */


public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquake) {
        super(context, 0, earthquake);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.row, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        String currentMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        magTextView.setText(currentMagnitude);

        // Set the proper background color for the circle.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        // Split the "near of" and "the primary location".
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);

        String locationOffset = locationOffset(currentEarthquake.getLocation());
        locationOffsetView.setText(locationOffset);

        String primaryLocation = primaryLocation(currentEarthquake.getLocation());
        primaryLocationView.setText(primaryLocation);


        // Find the TextView in the list_item.xml layout with the ID version_number
            //TextView locTextView = (TextView) listItemView.findViewById(R.id.location);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
           //locTextView.setText(currentEarthquake.getLocation());

        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.US);
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.US);
        timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return timeFormat.format(dateObject);
    }

    private String locationOffset(String location) {
        String[] locationOffset = location.split("of");

        if( locationOffset.length !=2 ) {
            return getContext().getString(R.string.near_the);
        } else {
            return locationOffset[0] + " of ";
        }
    }

    private String primaryLocation(String location) {


            String[] primaryLocation = location.split("of");

        if( primaryLocation.length != 2) {
            return primaryLocation[0];
        } else {
            return primaryLocation[1];
        }
    }
}