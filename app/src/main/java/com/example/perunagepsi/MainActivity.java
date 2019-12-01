package com.example.perunagepsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.location.Address;
import android.location.Geocoder;
import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    TextView txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.textViewGPS);
        txt2 = (TextView) findViewById(R.id.textViewGPS2);

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);

        Gepsi g = new Gepsi(getApplicationContext());
        Location lastKnownLocation = g.getLocation();
        double lat = lastKnownLocation.getLatitude();
        double lon = lastKnownLocation.getLongitude();
        txt.setText("Latitude:"+lat+"\nLongitude"+ lon);

        //Reverse Geocoding osuus tästä lähtien

        Geocoder gc = new Geocoder(this, Locale.getDefault());
        try{
            List<Address> addresses = gc.getFromLocation(lat,lon,1);
            StringBuilder sb = new StringBuilder();
            if (addresses.size()>0){
                Address address = addresses.get(0);
                for (int i = 0; i < address.getMaxAddressLineIndex();i++)
                    sb.append(address.getAddressLine(i)).append("\n");
                    sb.append(address.getLocality()).append("\n");
                    sb.append(address.getCountryName());
            }
            txt2.setText(sb.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }



                }
            }
