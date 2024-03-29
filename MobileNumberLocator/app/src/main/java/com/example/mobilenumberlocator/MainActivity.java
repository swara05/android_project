package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView num_location,recharge,location_info,ussd_code,bank,nearby,sim_info,setting,traffic_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num_location = findViewById(R.id.num_location);
        recharge = findViewById(R.id.recharge);
        location_info = findViewById(R.id.location_info);
        ussd_code = findViewById(R.id.ussd_code);
        bank = findViewById(R.id.bank);
        nearby = findViewById(R.id.nearby);
        sim_info = findViewById(R.id.sim_info);
        setting = findViewById(R.id.setting);
        traffic_area = findViewById(R.id.traffic_area);

        num_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,NumberLocator.class);
                startActivity(i);
            }
        });

        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,RechargePlans.class);
                startActivity(i);
            }
        });

        location_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Locationinfo.class);
                startActivity(i);
            }
        });

        ussd_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,USSDCodes.class);
                startActivity(i);
            }
        });

        bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Bank.class);
                startActivity(i);
            }
        });

        nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,NearByMeActivity.class);
                startActivity(i);
            }
        });

        sim_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SIMInfo.class);
                startActivity(i);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Settings.class);
                startActivity(i);
            }
        });

        traffic_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MapShow.class);
                startActivity(i);
            }
        });
    }
}