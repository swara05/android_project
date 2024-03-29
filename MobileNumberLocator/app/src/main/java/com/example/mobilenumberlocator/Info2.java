package com.example.mobilenumberlocator;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.format.Formatter;


public class Info2 extends Fragment {

    TextView cpu_core, freq, instruction, network, ip, mac, operator, country, roaming, service_state;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        cpu_core = getView().findViewById(R.id.cpu_core);
        freq = getView().findViewById(R.id.freq);
        instruction = getView().findViewById(R.id.instruction);
        network = getView().findViewById(R.id.network);
        ip = getView().findViewById(R.id.ip);
        mac = getView().findViewById(R.id.mac);
        operator = getView().findViewById(R.id.operator);
        country = getView().findViewById(R.id.country);
        roaming = getView().findViewById(R.id.roaming);
        service_state = getView().findViewById(R.id.service_state);

        String numOfCores = Integer.toString(Runtime.getRuntime().availableProcessors());
        cpu_core.setText(numOfCores);

        String maxFreq = "";
        try {
            RandomAccessFile reader = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
            maxFreq = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String instructionSet = Build.SUPPORTED_ABIS[0];

        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        String networkType = activeNetwork.getTypeName();

        Context context = requireContext().getApplicationContext();
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        String ipAdd = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        ip.setText(ipAdd);

        Log.e("TAG", "onCreate:++++++++++++++++++ ip " + ip);

        WifiManager wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        String macAddress = wifiInfo.getMacAddress();
        mac.setText(macAddress);

        TelephonyManager manager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);

        String countryCode = manager.getNetworkCountryIso();

        String operatorName = manager.getNetworkOperatorName();

      //  String serviceState = Integer.toString(manager.getServiceState().getState());

        String isRoaming = Boolean.toString(manager.isNetworkRoaming());

        operator.setText(operatorName);
        country.setText(countryCode);
       // service_state.setText(serviceState);

        service_state.setText("");

        if(isRoaming.matches("false")){
            roaming.setText("No");
        }else
        {
            roaming.setText("Yes");
        }

        freq.setText(maxFreq + " Hz");
        instruction.setText(instructionSet);
        network.setText(networkType);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info2, container, false);
    }
}