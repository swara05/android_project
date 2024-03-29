package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AadharPeLoan extends AppCompatActivity {

    ImageView aadharloan;
    TextView an1,an2,an3,an4,an5,an6,an7,an8,an9,an10,an11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar_pe_loan);

        aadharloan = findViewById(R.id.aadharloan);
        an1 = findViewById(R.id.an1);
        an2 = findViewById(R.id.an2);
        an3 = findViewById(R.id.an3);
        an4 = findViewById(R.id.an4);
        an5 = findViewById(R.id.an5);
        an6 = findViewById(R.id.an6);
        an7 = findViewById(R.id.an7);
        an8 = findViewById(R.id.an8);
        an9 = findViewById(R.id.an9);
        an10 = findViewById(R.id.an10);
        an11 = findViewById(R.id.an11);

        aadharloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        an1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AadharPeLoan.this,Apeloan1.class);
                startActivity(i);
            }
        });

        an2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(AadharPeLoan.this,Apeloan2.class);
                startActivity(i2);
            }
        });

        an3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(AadharPeLoan.this,Apeloan3.class);
                startActivity(i3);
            }
        });

        an4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(AadharPeLoan.this,Apeloan4.class);
                startActivity(i4);
            }
        });
        an5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(AadharPeLoan.this,Apeloan5.class);
                startActivity(i5);
            }
        });

        an6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6 = new Intent(AadharPeLoan.this,Apeloan6.class);
                startActivity(i6);
            }
        });

        an7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7 = new Intent(AadharPeLoan.this,Apeloan7.class);
                startActivity(i7);
            }
        });

        an8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i8 = new Intent(AadharPeLoan.this,Apeloan8.class);
                startActivity(i8);
            }
        });

        an9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i9 = new Intent(AadharPeLoan.this,Apeloan9.class);
                startActivity(i9);
            }
        });

        an10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i10 = new Intent(AadharPeLoan.this,Apeloan10.class);
                startActivity(i10);
            }
        });

        an11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i11 = new Intent(AadharPeLoan.this,Apeloan11.class);
                startActivity(i11);
            }
        });

    }
}