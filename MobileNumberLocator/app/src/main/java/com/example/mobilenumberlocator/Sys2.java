package com.example.mobilenumberlocator;

import static android.content.Context.BATTERY_SERVICE;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Sys2 extends Fragment {

    TextView blevel,bstatus,bhealth,btemp,btech,bvolt,btime;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        blevel = getView().findViewById(R.id.blevel);
        bstatus = getView().findViewById(R.id.bstatus);
        bhealth = getView().findViewById(R.id.bhealth);
        btemp = getView().findViewById(R.id.btemp);
        btech = getView().findViewById(R.id.btech);
        bvolt = getView().findViewById(R.id.bvolt);
        btime = getView().findViewById(R.id.btime);

//        updateView(new BatteryInfo(PreferenceManager.getDefaultSharedPreferences(getContext())));

        // Get battery manager
        BatteryManager batteryManager = (BatteryManager) getContext().getSystemService(BATTERY_SERVICE);

// Get battery level
        int batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);

// Get battery status
        int batteryStatus = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_STATUS);

//// Get battery health
//        int batteryHealth = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_HEALTH);
//
//// Get battery temperature
//        int batteryTemp = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_TEMPERATURE) / 10;
//
//// Get battery technology
//        String batteryTech = batteryManager.getProperty(BatteryManager.BATTERY_PROPERTY_TECHNOLOGY);
//
//// Get battery voltage
//        int batteryVoltage = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_VOLTAGE);

// Get system uptime
        long uptime = SystemClock.elapsedRealtime() / 1000;

        blevel.setText(Integer.toString(batteryLevel) + "%");
        bstatus.setText(Integer.toString(batteryStatus));
        btime.setText(Long.toString(uptime)+ " seconds");


        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatu = getContext().registerReceiver(null, intentFilter);

        int health = batteryStatu.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);

        if (health == BatteryManager.BATTERY_HEALTH_GOOD) {
            bhealth.setText("Good");
        } else if (health == BatteryManager.BATTERY_HEALTH_OVERHEAT) {
            bhealth.setText("Overheat");
        } else if (health == BatteryManager.BATTERY_HEALTH_DEAD) {
            bhealth.setText("Dead");
        } else if (health == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE) {
            bhealth.setText("Over voltage");

        } else if (health == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE) {
            bhealth.setText("Unspecified failure");

        } else if (health == BatteryManager.BATTERY_HEALTH_COLD) {
            bhealth.setText("Cold");

        } else {
            bhealth.setText("Unknown");

        }



        int batteryTemp = batteryStatu.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
        float batteryTempCelsius = batteryTemp / 10.0f;
        String batteryTempString = batteryTempCelsius + " \u2103"; // adds degree Celsius symbol
        btemp.setText(batteryTempString);

        BatteryManager batteryManager1 = (BatteryManager) getActivity().getSystemService(Context.BATTERY_SERVICE);

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus2 = getContext().registerReceiver(null, ifilter);

        String batteryTechnology = batteryStatus2.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);

        btech.setText(batteryTechnology);



//        int batteryVoltage = batteryManager.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
//        float batteryVoltageVolts = batteryVoltage / 1000.0f;
//        String batteryVoltageString = batteryVoltageVolts + " V";
//        bvolt.setText(batteryVoltageString);



        int voltage = batteryStatu.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
        if (voltage != -1) {
            float voltageFloat = (float)voltage / 1000.0f; // Convert millivolts to volts
            bvolt.setText(voltageFloat + " V");
        } else {
            bvolt.setText("not available");
        }

//        Log.d("Battery", "Level: " + batteryLevel + "%");
//        Log.d("Battery", "Status: " + batteryStatusToString(batteryStatus));
//        Log.d("Battery", "Health: " + batteryHealthToString(batteryHealth));
//        Log.d("Battery", "Temperature: " + batteryTemp + "°C");
//        Log.d("Battery", "Technology: " + batteryTech);
//        Log.d("Battery", "Voltage: " + batteryVoltage + " mV");
//        Log.d("System", "Uptime: " + uptime + " seconds");
    }

//    public synchronized void updateView(BatteryInfo batteryInfo) {
//        this.btemp.setText(getTemperature(batteryInfo));
//        this.bvolt.setText(getVoltage(batteryInfo));
//        this.btech.setText(getTechnology(batteryInfo));
//    }


//    private String getTemperature(BatteryInfo batteryInfo) {
//        float temperature = ((float) batteryInfo.getTemperature()) / 10.0f;
//        StringBuilder sb = new StringBuilder();
//        sb.append(temperature);
//        sb.append("° C");
//        return sb.toString();
//    }

//    private String getTechnology(BatteryInfo batteryInfo) {
//        return batteryInfo.getTechnology();
//    }

//    private String getVoltage(BatteryInfo batteryInfo) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(batteryInfo.getVoltage());
//        sb.append(" mV");
//        return sb.toString();
//    }

//        int health = batteryInfo.getHealth();
//        if (health == 2) {
//            return getString(R.string.batteryHealthGood);
//        }
//        if (health == 3) {
//            return getString(R.string.batteryHealthOverheat);
//        }
//        if (health == 4) {
//            return getString(R.string.batteryHealthDead);
//
//        }
//        if (health == 5) {
//            return getString(R.string.batteryHealthOverVoltage);
//        }
//        if (health != 6) {
//            return getString(R.string.Unknown);
//        }
//        return getString(R.string.batteryHealthUnspecifiedFailure);


    // Helper methods to convert battery status and health constants to strings
    private String batteryStatusToString(int status) {
        switch (status) {
            case BatteryManager.BATTERY_STATUS_CHARGING:
                return "Charging";
            case BatteryManager.BATTERY_STATUS_DISCHARGING:
                return "Discharging";
            case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                return "Not Charging";
            case BatteryManager.BATTERY_STATUS_FULL:
                return "Full";
            case BatteryManager.BATTERY_STATUS_UNKNOWN:
            default:
                return "Unknown";
        }
    }

//    private String batteryHealthToString(int health) {
//        switch (health) {
//            case BatteryManager.BATTERY_HEALTH_GOOD:
//                return "Good";
//            case BatteryManager.BATTERY_HEALTH_OVERHEAT:
//                return "Overheat";
//            case BatteryManager.BATTERY_HEALTH_DEAD:
//                return "Dead";
//            case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
//                return "Over Voltage";
//            case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
//                return "Unspecified Failure";
//            case BatteryManager.BATTERY_HEALTH_COLD:
//                return "Cold";
//            case BatteryManager.BATTERY_HEALTH_UNKNOWN:
//            default:
//                return "Unknown";
//        }
//    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sys2, container, false);
    }
}