
package com.example.pavel.mapbox.model;

import android.content.Context;

import com.example.pavel.mapbox.Placeable;
import com.example.pavel.mapbox.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;

import java.util.List;

public class GeoMap implements Placeable{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public void placeMarkers(MapboxMap mapboxMap, Context context) {
        for (Feature feature:features) {


            if (feature.getProperties().getColor().equals("yellow")){
                Icon icon1 = IconFactory.getInstance(context).fromResource(R.drawable.yelow_marker);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(feature.getGeometry().getCoordinates().get(0), feature.getGeometry().getCoordinates().get(1)))
                        .title(feature.getProperties().getName())
                        .snippet(feature.getProperties().getColor())
                        .icon(icon1)

                );
            }
            if (feature.getProperties().getColor().equals("black")){
                Icon icon1 = IconFactory.getInstance(context).fromResource(R.drawable.black_marker);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(feature.getGeometry().getCoordinates().get(0), feature.getGeometry().getCoordinates().get(1)))
                        .title(feature.getProperties().getName())
                        .snippet(feature.getProperties().getColor())
                        .icon(icon1)

                );
            }
            if (feature.getProperties().getColor().equals("orange")){
                Icon icon1 = IconFactory.getInstance(context).fromResource(R.drawable.orange_marker);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(feature.getGeometry().getCoordinates().get(0), feature.getGeometry().getCoordinates().get(1)))
                        .title(feature.getProperties().getName())
                        .snippet(feature.getProperties().getColor())
                        .icon(icon1)

                );
            }




        }
    }
}
