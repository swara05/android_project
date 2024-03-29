package com.example.makemoneyfromcreditcard.Utils2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class Global extends Application {

    private static Global mInstance;
    private static Context mContext;
    private static AppOpenManager appOpenManager;

    static SharedPreferences preferences;
    static SharedPreferences.Editor prefEditor;

    @Override
    public void onCreate() {
        super.onCreate();


        preferences = getSharedPreferences("news", MODE_PRIVATE);
        prefEditor = preferences.edit();
        mInstance = this;
        mContext = this;

            MobileAds.initialize(this, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(InitializationStatus initializationStatus) {}
            });

            appOpenManager = new AppOpenManager(this);


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public static synchronized Context getContext() {
        return mContext;
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission")
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static void set_email_add(String r_id) {
        prefEditor.putString("email_add", r_id).commit();
    }

    public static String get_email_add() {
        return preferences.getString("email_add", "");
    }

}
