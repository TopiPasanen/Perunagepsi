package com.example.perunagepsi;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class Gepsi implements LocationListener {
    Context context;
        public Gepsi(Context c){
            context = c;
        }


    public Location getLocation() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean GPSenabled = locationManager.isProviderEnabled(locationManager.NETWORK_PROVIDER);
        // String locationProvider = LocationManager.NETWORK_PROVIDER;
        if (GPSenabled) {
            locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER, 3000, 10, this);
            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            return lastKnownLocation;
        }
        return null;
    }
    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
