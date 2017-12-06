package com.example.android.bluetoothchat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.example.android.common.activities.SampleActivityBase;

/**
 * Created by omart on 12/3/2017.
 */

public class VictimScreen extends SampleActivityBase {

    private FragmentTransaction transaction;
    private VictimChat fragment;
    String latitude;
    String longitude;
    Location location;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victim_layout);
        LocationListener mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(final Location location) {
                //your code here
            }
            @Override
            public void onStatusChanged(String i, int ik, Bundle s){

            }
            @Override
            public void onProviderEnabled(String i){

            }
            @Override
            public void onProviderDisabled(String i){

            }
        };
        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(VictimScreen.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(VictimScreen.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(VictimScreen.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        }else{
            locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 500.0f, mLocationListener);
            location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            latitude = Double.toString(location.getLatitude());
            longitude = Double.toString(location.getLongitude());
        }


        if (savedInstanceState == null) {
            transaction = getSupportFragmentManager().beginTransaction();
            fragment = new VictimChat();
            fragment.setLat(latitude);
            fragment.setLong(longitude);
            fragment.setType("Victim");
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }
}
