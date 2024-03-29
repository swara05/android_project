package com.example.mobilenumberlocator;

import static android.content.Context.ACTIVITY_SERVICE;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.os.StatFs;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;


public class Sys1 extends Fragment {

    TextView tram,uram,fram,tspace,fspace,etspace,efspace;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tram = getView().findViewById(R.id.tram);
        uram = getView().findViewById(R.id.uram);
        fram = getView().findViewById(R.id.fram);
        tspace = getView().findViewById(R.id.tspace);
        fspace = getView().findViewById(R.id.fspace);
        etspace = getView().findViewById(R.id.etspace);
        efspace = getView().findViewById(R.id.efspace);

        // Get activity manager
        ActivityManager activityManager = (ActivityManager) getContext().getApplicationContext().getSystemService(ACTIVITY_SERVICE);

        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

// Calculate RAM values in MB
        String totalRAM = Long.toString(memoryInfo.totalMem / 1048576L);
        String usedRAM = Long.toString((memoryInfo.totalMem - memoryInfo.availMem) / 1048576L);
        String freeRAM = Long.toString(memoryInfo.availMem / 1048576L);

        tram.setText(totalRAM + " MB");
        uram.setText(usedRAM + " MB");
        fram.setText(freeRAM + " MB");

        // Get internal storage directory
        File path = Environment.getDataDirectory();

// Get internal storage stats
        StatFs stat = new StatFs(path.getPath());

// Calculate storage values in MB
        long blockSize = stat.getBlockSizeLong();
        long totalStorage = (stat.getBlockCountLong() * blockSize) / 1048576L;
        long freeStorage = (stat.getAvailableBlocksLong() * blockSize) / 1048576L;

        tspace.setText(Long.toString(totalStorage) + " MB");
        fspace.setText(Long.toString(freeStorage) + " MB");

        // Get external storage directory
        File pathe = Environment.getExternalStorageDirectory();

// Get external storage stats
        StatFs state = new StatFs(pathe.getPath());

// Calculate storage values in MB
        long blockSize1 = state.getBlockSizeLong();
        long totalSpace = (state.getBlockCountLong() * blockSize1) / 1048576L;
        long freeSpace = (state.getAvailableBlocksLong() * blockSize1) / 1048576L;

        etspace.setText(Long.toString(totalSpace) + " MB");
        efspace.setText(Long.toString(freeSpace) + " MB");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sys1, container, false);
    }
}