package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AadharToNumber extends AppCompatActivity {

    ImageView bef1;
    TextView an1,an2,an3,an4,an5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar_to_number);

        bef1 = findViewById(R.id.bef1);
        an1 = findViewById(R.id.an1);
        an2 = findViewById(R.id.an2);
        an3 = findViewById(R.id.an3);
        an4 = findViewById(R.id.an4);
        an5 = findViewById(R.id.an5);

        bef1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        an1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n1 = new Intent(AadharToNumber.this,AadharToNumberViaOTP.class);
                startActivity(n1);
            }
        });

        an2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n2 = new Intent(AadharToNumber.this,AadharToStore.class);
                startActivity(n2);
            }
        });

        an3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n3 = new Intent(AadharToNumber.this,WhyRegisterWithNumber.class);
                startActivity(n3);
            }
        });

        an4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n4 = new Intent(AadharToNumber.this,FeeForRegister.class);
                startActivity(n4);
            }
        });

        an5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n5 = new Intent(AadharToNumber.this,DocsRequiredWithNumber.class);
                startActivity(n5);
            }
        });
    }
}