package com.example.earthquake;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);


        // get the list of earthquakes from query util file
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();
        for (Earthquake ele : earthquakes) {
            Log.v("MainActivity", "checking for the magnitude : " + ele.getMagnitude());
        }
//        ArrayList<Earthquake> earthquakes = new ArrayList<>();
//        earthquakes.add(new Earthquake("7.2", "Nepal", "12345"));


        //create a new EarthquakeAdapter of earthquakes
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, earthquakes);

        //find the reference to the list view in the layout
        ListView earthquakeListView = findViewById(R.id.list);

        //Set the adapter on the list view
        //so that list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Earthquake currentEarthquake = earthquakeAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }
}