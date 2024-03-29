package com.example.mobilenumberlocator;


import android.app.Activity;
import android.content.Context;

import android.graphics.Point;
import android.hardware.display.DisplayManager;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.util.DisplayMetrics;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;


public class Info1 extends Fragment {

        TextView dname,mname,bname,pname,resolution,density,refresh,physical,version,level;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_info1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dname = getView().findViewById(R.id.dname);
        mname = getView().findViewById(R.id.mname);
        bname = getView().findViewById(R.id.bname);
        pname = getView().findViewById(R.id.pname);
        resolution = getView().findViewById(R.id.resolution);
        density = getView().findViewById(R.id.density);
        refresh = getView().findViewById(R.id.refresh);
        physical = getView().findViewById(R.id.physical);
        version = getView().findViewById(R.id.version);
        level = getView().findViewById(R.id.api_level);

        String deviceName = Build.DEVICE;
        String modelName = Build.MODEL;
        String brandName = Build.BRAND;
        String productName = Build.PRODUCT;

        dname.setText(deviceName);
        mname.setText(modelName);
        bname.setText(brandName);
        pname.setText(productName);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

//        int deviceWidth = displayMetrics.widthPixels;
//        int deviceHeight = displayMetrics.heightPixels;
        float deviceDensity = displayMetrics.density;
        int deviceDensityDpi = displayMetrics.densityDpi;

        DisplayManager displayManager = (DisplayManager) getContext().getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(Display.DEFAULT_DISPLAY);
        String refreshRate = Float.toString(display.getRefreshRate());
        refresh.setText(refreshRate + " Hz");

        String res = getScreenResolution(getContext());
        resolution.setText(res);
      //  density.setText(deviceDensityDpi);
        DisplayMetrics displaymetrics;
        displaymetrics = new DisplayMetrics();
//        float value = 0;
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//        value = getResources().getDisplayMetrics().density;
        density.setText(deviceDensityDpi + " dpi");

        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

//        float xdpi = displayMetrics.xdpi;
//        float ydpi = displayMetrics.ydpi;
//        float widthInches = displayMetrics.widthPixels / xdpi;
//        float heightInches = displayMetrics.heightPixels / ydpi;
//        double diagonalInches = Math.sqrt(Math.pow(widthInches, 2) + Math.pow(heightInches, 2));

        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        double wi=(double)width/(double)dm.xdpi;
        double hi=(double)height/(double)dm.ydpi;
        double x = Math.pow(wi,2);
        double y = Math.pow(hi,2);
        double screenInches = Math.sqrt(x+y);

        Log.e("tag", "onViewCreated: " + screenInches );

        String stringdouble= Double.toString(screenInches);
        physical.setText(stringdouble);

        String androidVersion = Build.VERSION.RELEASE;
        int apiLevel = Build.VERSION.SDK_INT;

        level.setText(String.valueOf(apiLevel));

        version.setText(androidVersion);
    }

    private static String getScreenResolution(Context context)
    {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        return width+"×"+height;
    }

}