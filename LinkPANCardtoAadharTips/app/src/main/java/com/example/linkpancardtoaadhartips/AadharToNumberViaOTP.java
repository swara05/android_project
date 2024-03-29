package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AadharToNumberViaOTP extends AppCompatActivity {

    ImageView i1;
    TextView step1,step2,step3,step4,step5,step6,step7,step8,step9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar_to_number_via_otp);

        i1 = findViewById(R.id.i1);
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step3 = findViewById(R.id.step3);
        step4 = findViewById(R.id.step4);
        step5 = findViewById(R.id.step5);
        step6 = findViewById(R.id.step6);
        step7 = findViewById(R.id.step7);
        step8 = findViewById(R.id.step8);
        step9 = findViewById(R.id.step9);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(AadharToNumberViaOTP.this,NumOTP1.class);
                startActivity(i1);
            }
        });

        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(AadharToNumberViaOTP.this,NumOTP2.class);
                startActivity(i2);
            }
        });

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(AadharToNumberViaOTP.this,NumOTP3.class);
                startActivity(i3);
            }
        });

        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(AadharToNumberViaOTP.this,NumOTP4.class);
                startActivity(i4);
            }
        });

        step5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(AadharToNumberViaOTP.this,NumOTP5.class);
                startActivity(i5);
            }
        });

        step6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6= new Intent(AadharToNumberViaOTP.this,NumOTP6.class);
                startActivity(i6);
            }
        });

        step7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7 = new Intent(AadharToNumberViaOTP.this,NumOTP7.class);
                startActivity(i7);
            }
        });
        step8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i8 = new Intent(AadharToNumberViaOTP.this,NumOTP8.class);
                startActivity(i8);
            }
        });
        step9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i9 = new Intent(AadharToNumberViaOTP.this,NumOTP9.class);
                startActivity(i9);
            }
        });

    }
}