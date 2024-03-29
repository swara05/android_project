package com.example.mobilenumberlocator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class Locationinfo extends AppCompatActivity implements LocationListener{


    ImageView back;
    TextView latitude, longitude, state, city, country, add;
    Button map;
   LocationManager locationManager;
   LinearLayout main;
    com.tuyenmonkey.mkloader.MKLoader loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationinfo);


        back = findViewById(R.id.back);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        state = findViewById(R.id.state);
        city = findViewById(R.id.city);
        country = findViewById(R.id.country);
        map = findViewById(R.id.map);
        add = findViewById(R.id.add);
        main = findViewById(R.id.main);
        loading = findViewById(R.id.loading);



        grantPermission();
        checkLocationIsEnableorNot(); //this will redirect us to location setting
        getLocation();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Locationinfo.this,MapShow.class);
                startActivity(i);
            }
        });

    }

    private void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private void checkLocationIsEnableorNot() {

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gpsEnable = false;
        boolean networkenable = false;

        try {
            gpsEnable = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            networkenable = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(!gpsEnable && !networkenable){
            new AlertDialog.Builder(Locationinfo.this)
                    .setTitle("Enable GPS Service")
                    .setCancelable(false)
                    .setPositiveButton("Enable", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    }).setNegativeButton("Cancle",null)
                    .show();
        }
    }

    private void grantPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},101);
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

         try {
             Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
             List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

             if(latitude.equals("")){

                 loading.setVisibility(View.VISIBLE);
                 main.setVisibility(View.GONE);
                 map.setVisibility(View.GONE);
             }else {
                 loading.setVisibility(View.GONE);
                 main.setVisibility(View.VISIBLE);
                 map.setVisibility(View.VISIBLE);
                 double lat = (double) (location.getLatitude());
                 double lng = (double) (location.getLongitude());

                 latitude.setText(String.valueOf(lat));
                 longitude.setText(String.valueOf(lng));

                 country.setText(addresses.get(0).getCountryName());
                 state.setText(addresses.get(0).getAdminArea());
                 city.setText(addresses.get(0).getLocality());
                 add.setText(addresses.get(0).getAddressLine(0));
             }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }
}