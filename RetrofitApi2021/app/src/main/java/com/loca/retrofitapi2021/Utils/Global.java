package com.loca.retrofitapi2021.Utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;




public class Global extends Application {

    private static Global mInstance;
    private static Context mContext;
    static SharedPreferences preferences;
    static SharedPreferences.Editor prefEditor;

    @Override
    public void onCreate() {
        super.onCreate();

        preferences = getSharedPreferences("news", MODE_PRIVATE);
        prefEditor = preferences.edit();
        mInstance = this;
        mContext = this;
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

    public static void set_name(String r_id) {
        prefEditor.putString("name", r_id).commit();
    }

    public static String get_name() {
        return preferences.getString("name", "");
    }

    public static void set_age(String r_id) {
        prefEditor.putString("age", r_id).commit();
    }

    public static String get_age() {
        return preferences.getString("age", "");
    }

    public static void set_study(String r_id) {
        prefEditor.putString("study", r_id).commit();
    }

    public static String get_study() {
        return preferences.getString("study", "");
    }

    public static void set_number(String r_id) {
        prefEditor.putString("number", r_id).commit();
    }

    public static String get_number() {
        return preferences.getString("number", "");
    }

    public static void set_city(String r_id) {
        prefEditor.putString("city", r_id).commit();
    }

    public static String get_city() {
        return preferences.getString("city", "");
    }


}
