package com.example.restaurantdispatch;


import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionChecker extends Application {
    public static boolean isConnectedToNetwork(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);


        boolean isConnected = false;

        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

            isConnected = (activeNetwork != null) && (activeNetwork.isConnected());
        }
        return isConnected;
    }

    private boolean haveNetwork() {
        boolean have_WIFI = false;
        boolean have_MobileData = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInformation = connectivityManager.getAllNetworkInfo();

        for (NetworkInfo info : networkInformation) {

            if (info.getTypeName().equalsIgnoreCase("WIFI"))

                if (info.isConnected())
                    have_WIFI = true;
            if (info.getTypeName().equalsIgnoreCase("MOBILE"))
                if (info.isConnected())
                    have_MobileData = true;
        }
        return have_MobileData || have_WIFI;
    }
}