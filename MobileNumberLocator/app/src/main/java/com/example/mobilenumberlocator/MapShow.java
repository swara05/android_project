package com.example.mobilenumberlocator;


import static com.example.mobilenumberlocator.R.array.layers_array;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapShow extends FragmentActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener, ActivityCompat.OnRequestPermissionsResultCallback {

    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    public static final int REQUEST_CODE = 101;
     CheckBox mBuildingsCheckbox;
     CheckBox mIndoorCheckbox;
     CheckBox mMyLocationCheckbox;
     Spinner mSpinner;
     CheckBox mTrafficCheckbox;
     public  GoogleMap mMap;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_show);

        mBuildingsCheckbox = findViewById(R.id.buildings);
        mIndoorCheckbox = findViewById(R.id.indoor);
        mMyLocationCheckbox = findViewById(R.id.my_location);
        mTrafficCheckbox = findViewById(R.id.traffic);
        mSpinner = findViewById(R.id.layers_spinner);

        getWindow().setFlags(1024, 1024);
        ArrayAdapter<CharSequence> createFromResource =
                ArrayAdapter.createFromResource(this, layers_array, com.hbb20.R.layout.support_simple_spinner_dropdown_item);
        createFromResource.setDropDownViewResource(com.tuyenmonkey.mkloader.R.layout.support_simple_spinner_dropdown_item);
        this.mSpinner.setAdapter(createFromResource);
        this.mSpinner.setOnItemSelectedListener(this);


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();
    }


    private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    currentLocation = location;
                   
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
                    supportMapFragment.getMapAsync(MapShow.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        this.mMap = googleMap;
        Log.e("TAG", "onMapReady: " + mMap );

        updateMapType();
        updateTraffic();
        updateMyLocation();

        LatLng latLng = new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng)
                .title("I'm Here.");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
        googleMap.addMarker(markerOptions);

        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.mMap.setMyLocationEnabled(true);
            this.mMap.setOnMyLocationChangeListener(myLocationChangeListener());
        }
    }

    private GoogleMap.OnMyLocationChangeListener myLocationChangeListener() {
        return new GoogleMap.OnMyLocationChangeListener() {
            public void onMyLocationChange(Location location) {
                MapShow.this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 16.0f));
            }
        };
    }

    @SuppressLint("WrongConstant")
    private boolean checkReady() {
        if (this.mMap != null) {
            return true;
        }
        Toast.makeText(this, R.string.map_not_ready, 0).show();
        return false;
    }

    public void onTrafficToggled(View view) {
        updateTraffic();
    }

    private void updateTraffic() {
        if (checkReady()) {
            this.mMap.setTrafficEnabled(this.mTrafficCheckbox.isChecked());
        }
    }

    public void onMyLocationToggled(View view) {
        updateMyLocation();
    }

    private void updateMyLocation() {
        if (checkReady()) {
            if (this.mMyLocationCheckbox.isChecked()) {
                if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    this.mMap.setMyLocationEnabled(true);
                } else {
                    this.mMyLocationCheckbox.setChecked(false);
                }
            } else if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                this.mMap.setMyLocationEnabled(false);
            }
        }
    }

    public void onResumeFragments() {
        super.onResumeFragments();
    }

    public void onBuildingsToggled(View view) {
        updateBuildings();
    }

    private void updateBuildings() {
        if (checkReady()) {
            this.mMap.setBuildingsEnabled(this.mBuildingsCheckbox.isChecked());
        }
    }

    public void onIndoorToggled(View view) {
        updateIndoor();
    }

    private void updateIndoor() {
        if (checkReady()) {
            this.mMap.setIndoorEnabled(this.mIndoorCheckbox.isChecked());
        }
    }
    private void updateMapType() {


        String str = (String) this.mSpinner.getSelectedItem();

       if (this.mMap != null && str!= null) {

           Log.e("TAG", "updateMapType: +++++mMap" + mMap );

           Log.e("TAG", "updateMapType: ++++++ "  + str );


           Log.d("tag",str);
           if (str.equals(getString(R.string.normal))) {
               this.mMap.setMapType(1);
           } else if (str.equals(getString(R.string.none_map))) {
               this.mMap.setMapType(0);
           } else if (str.equals(getString(R.string.satellite))) {
               this.mMap.setMapType(2);
           } else if (str.equals(getString(R.string.hybrid))) {
               this.mMap.setMapType(4);
           } else if (str.equals(getString(R.string.terrain))) {
               this.mMap.setMapType(3);
           } else {
               Log.i("LDA", "Error setting layer with name " + str);
           }



       }else{
           Log.e("TAG", "updateMapType: else "  );
       }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case REQUEST_CODE:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    fetchLastLocation();
                }
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        updateMapType();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

