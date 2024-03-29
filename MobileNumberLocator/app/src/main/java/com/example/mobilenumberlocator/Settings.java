package com.example.mobilenumberlocator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    LinearLayout audio,device,system;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        back = findViewById(R.id.back);

        audio = findViewById(R.id.audio);
        device = findViewById(R.id.device);
        system = findViewById(R.id.system);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Settings.this,AudioInfo.class);
                startActivity(i);
            }
        });
        device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Settings.this,DeviceInfo.class);
                startActivity(i);
            }
        });

        system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Settings.this, SystemInfo.class);
                startActivity(i);
            }
        });
    }
}