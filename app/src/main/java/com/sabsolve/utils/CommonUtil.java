package com.sabsolve.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by SONY on 10/13/2015.
 */
public class CommonUtil
{
    public static boolean isInternetWorking(Activity activity)
    {
        boolean internetConnected = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo wifiNetwork = connectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobileNetwork = connectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            boolean wifiConnected = wifiNetwork != null && wifiNetwork.isConnected();
            boolean mobileNetworkConnected = mobileNetwork != null && mobileNetwork.isConnected();

            internetConnected = wifiConnected && mobileNetworkConnected;

        } catch (Exception e) {

        }
        return internetConnected;
    }
}
