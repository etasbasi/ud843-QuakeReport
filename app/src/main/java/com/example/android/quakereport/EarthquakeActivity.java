/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
//        ArrayList<Earthquake> earthquakes = new ArrayList<>();
//        earthquakes.add(new Earthquake("5.5", "London", "January"));
//        earthquakes.add(new Earthquake("2.4", "Khartoum", "October"));
//        earthquakes.add(new Earthquake("4.0", "Paris", "21, December"));
//        earthquakes.add(new Earthquake("3.0", "Khartoum", "November"));

        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        earthquakeListView.setAdapter(adapter);



//        String[] mag = new String[] { "2.0", "3.2", "8.3", "4.2", "8.3", "1.2", "6.7", "5.9" };
//        String[] loc = new String[] { "Virginia", "Long Island", "New York", "California", "Ohio", "Istanbul", "Khartoum", "Spain"};
//        String[] time = new String[] { "12:00", "6:00", "2:23", "9:84", "10:43", "2:04", "0:00", "6:93" };
//
//        String[] from = new String[] { "mag", "loc", "time" };
//        int[] to = new int[] {R.id.mag, R.id.loc, R.id.time };
//
//        List<HashMap<String, Object>> fillMaps = new ArrayList<HashMap<String, Object>>();
//
//        for(int i = 0; i < 8; i++) {
//            HashMap<String, Object> map = new HashMap<String, Object>();
//            map.put("mag", mag[i]);
//            map.put("loc", loc[i]);
//            map.put("time", time[i]);
//            fillMaps.add(map);
//        }
//
//
//        SimpleAdapter adapter = new SimpleAdapter(this, fillMaps, R.layout.row, from, to);
//        earthquakeListView.setAdapter(adapter);


    }
}
