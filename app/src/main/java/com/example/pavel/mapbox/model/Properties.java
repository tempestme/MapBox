
package com.example.pavel.mapbox.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("marker-color")
    @Expose
    private String markerColor;
    @SerializedName("marker-size")
    @Expose
    private String markerSize;
    @SerializedName("marker-symbol")
    @Expose
    private String markerSymbol;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("color")
    @Expose
    private String color;

    public String getMarkerColor() {
        return markerColor;
    }

    public void setMarkerColor(String markerColor) {
        this.markerColor = markerColor;
    }

    public String getMarkerSize() {
        return markerSize;
    }

    public void setMarkerSize(String markerSize) {
        this.markerSize = markerSize;
    }

    public String getMarkerSymbol() {
        return markerSymbol;
    }

    public void setMarkerSymbol(String markerSymbol) {
        this.markerSymbol = markerSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
