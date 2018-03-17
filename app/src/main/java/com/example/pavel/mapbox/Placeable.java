package com.example.pavel.mapbox;

import android.content.Context;

import com.mapbox.mapboxsdk.maps.MapboxMap;

/**
 * Created by pavel on 16.03.18.
 */

public interface Placeable {
    public void placeMarkers(MapboxMap mapboxMap, Context context);

}
