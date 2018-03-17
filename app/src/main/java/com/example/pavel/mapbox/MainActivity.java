package com.example.pavel.mapbox;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.pavel.mapbox.model.GeoMap;
import com.google.gson.Gson;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private MapView mapView;
    private final static String token = "pk.eyJ1IjoidGVtcGVzdG1lIiwiYSI6ImNqZXJqMTRsYjBkbGYzM3BhdmNoeHFxaWcifQ.dtUw5rQI1-RVJD6tyzPNUA";
    private MapboxMap mapboxMap;
    private GeoMap markers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int LOCATION_PERMISSION_CODE = 101;
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_DENIED){
            String permissions[] = {Manifest.permission.ACCESS_FINE_LOCATION};
            requestPermissions(permissions,LOCATION_PERMISSION_CODE);
        }
        markers = new GeoMap();
        markers = getJsonFromFile();

        Mapbox.getInstance(getApplicationContext(),token);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

                markers.placeMarkers(mapboxMap, getApplicationContext());



            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    public GeoMap getJsonFromFile(){
        InputStream is = getResources().openRawResource(R.raw.map);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        GeoMap map = new Gson().fromJson(br, GeoMap.class);
        return map;

    }
}
