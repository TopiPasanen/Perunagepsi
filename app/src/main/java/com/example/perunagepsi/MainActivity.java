package com.example.perunagepsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.textViewGPS);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);

        Gepsi g = new Gepsi(getApplicationContext());
        Location lastKnownLocation = g.getLocation();
        double lat = lastKnownLocation.getLatitude();
        double lon = lastKnownLocation.getLongitude();
        txt.setText("Latitude:"+lat+"\n longitude"+ lon);


                }
            }
