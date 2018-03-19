package com.example.pavel.mapbox.model;

/**
 * Created by pavel on 19.03.18.
 */

public class WifiElement {
    private String title;
    private String security;
    private String level;

    public WifiElement(String title, String security, String level) {
        this.title = title;
        this.security = security;
        this.level = level;
    }

    public String getTitle() {
        return title;
    }
    public String getSecurity() {
        return security;
    }
    public String getLevel() {
        return level;
    }
}
