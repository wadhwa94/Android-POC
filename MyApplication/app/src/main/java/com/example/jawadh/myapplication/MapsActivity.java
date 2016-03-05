package com.example.jawadh.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.Manifest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.LocationServices;
import android.location.Location;
import android.support.v4.content.ContextCompat;
import android.content.Context;
import android.widget.TextView;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

   // Intent intent = getIntent();


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();

    }
        @Override
        public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
            Location mLastLocation = Main4Activity.func();
            //Location mLastLocation = (Location)intent.getStringExtra(Main4Activity.EXTRA_MESSAGE);
            LatLng currentLocation = new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(currentLocation).title("Marker at your current location"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
    }
}
