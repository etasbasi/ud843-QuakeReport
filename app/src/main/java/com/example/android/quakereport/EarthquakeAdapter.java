package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magTextView = (TextView) listItemView.findViewById(R.id.mag);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        magTextView.setText(currentEarthquake.getMagnitude());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView locTextView = (TextView) listItemView.findViewById(R.id.loc);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        locTextView.setText(currentEarthquake.getLocation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        timeTextView.setText(currentEarthquake.getDate());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}