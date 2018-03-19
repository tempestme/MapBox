package com.example.pavel.mapbox;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.widget.TextView;

/**
 * Created by pavel on 19.03.18.
 */

public class CellInfo {

    GsmCellLocation gsm;
    TelephonyManager tm;
    TextView cid;
    TextView lac;
    TextView mmc;
    TextView mnc;
    Context context;

    public CellInfo(Context context) {
        this.context = context;
    }

    private void getData() {
        this.tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            this.gsm = (GsmCellLocation) tm.getCellLocation();
            String networkOperator = tm.getNetworkOperator();
            mmc.setText(networkOperator.substring(0,3));
            mnc.setText(networkOperator.substring(3));
            cid.setText(Integer.toString(gsm.getCid()));
            lac.setText(Integer.toString(gsm.getLac()));
            return;
        }
        //psc.setText(Integer.toString(gsm.getPsc()));
    }
}
