package com.example.pavel.mapbox;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import com.example.pavel.mapbox.model.WifiElement;

import java.util.List;

/**
 * Created by pavel on 19.03.18.
 */

public class Wifi {
    private WifiElement[] nets;
    private WifiManager wifiManager;
    private List<ScanResult> wifiList;
    private Context context;

    public Wifi(Context context){
        this.wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        this.wifiManager.startScan();
        this.wifiList = this.wifiManager.getScanResults();

        this.nets = new WifiElement[wifiList.size()];
        for(int i = 0; i<wifiList.size(); i++){
            String item = wifiList.get(i).toString();
            String vector_item[] = item.split(",");
            String item_essid = vector_item[0];
            String item_capabilities = vector_item[2];
            String item_level = vector_item[3];
            String ssid = item_essid.split(": ")[1];
            String security = item_capabilities.split(": ")[1];
            String level = item_level.split(": ")[1];
            nets[i] = new WifiElement(ssid,security,level);
        }
    }

    public WifiElement[] getNets() {
        return nets;
    }
}
