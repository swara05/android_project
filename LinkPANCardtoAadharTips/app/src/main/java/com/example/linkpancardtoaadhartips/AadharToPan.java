package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AadharToPan extends AppCompatActivity {

    ImageView imBack;
    TextView ap1,ap2,ap3,ap4,ap5,ap6,ap7,ap8,ap9,ap10,ap11,ap12,ap13,ap14,ap15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar_to_pan);

        imBack = findViewById(R.id.imBack);
        ap1 = findViewById(R.id.ap1);
        ap2 = findViewById(R.id.ap2);
        ap3 = findViewById(R.id.ap3);
        ap4 = findViewById(R.id.ap4);
        ap5 = findViewById(R.id.ap5);
        ap6 = findViewById(R.id.ap6);
        ap7 = findViewById(R.id.ap7);
        ap8 = findViewById(R.id.ap8);
        ap9 = findViewById(R.id.ap9);
        ap10 = findViewById(R.id.ap10);
        ap11 = findViewById(R.id.ap11);
        ap12 = findViewById(R.id.ap12);
        ap13 = findViewById(R.id.ap13);
        ap14 = findViewById(R.id.ap14);
        ap15 = findViewById(R.id.ap15);

        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a1 = new Intent(AadharToPan.this,LinkWithNumberFirst.class);
                startActivity(a1);
            }
        });

        ap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a2 = new Intent(AadharToPan.this,ReVerifyNumber.class);
                startActivity(a2);
            }
        });

        ap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a3 = new Intent(AadharToPan.this,LinkRequired.class);
                startActivity(a3);
            }
        });


        ap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a4 = new Intent(AadharToPan.this,WhatAdharPan.class);
                startActivity(a4);
            }
        });

        ap5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a5 = new Intent(AadharToPan.this,RequiredDocs.class);
                startActivity(a5);
            }
        });

        ap6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a6 = new Intent(AadharToPan.this,LinkBothDetail.class);
                startActivity(a6);
            }
        });

        ap7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://incometaxindia.gov.in/Pages/tax-services/status-of-pan-nsdl.aspx"));
                startActivity(i);
            }
        });

        ap8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i8 = new Intent(Intent.ACTION_VIEW);
                i8.setData(Uri.parse("https://incometaxindia.gov.in/Pages/tax-services/online-pan-verification.aspx"));
                startActivity(i8);
            }
        });

        ap9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i9 = new Intent(Intent.ACTION_VIEW);
                i9.setData(Uri.parse("https://eportal.incometax.gov.in/iec/foservices/#/login"));
                startActivity(i9);
            }
        });

        ap10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i10 = new Intent(Intent.ACTION_VIEW);
                i10.setData(Uri.parse("https://eportal.incometax.gov.in/iec/foservices/#/login"));
                startActivity(i10);
            }
        });

        ap11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6 = new Intent(Intent.ACTION_VIEW);
                i6.setData(Uri.parse("https://eportal.incometax.gov.in/iec/foservices/#/login"));
                startActivity(i6);
            }
        });

        ap12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(Intent.ACTION_VIEW);
                i5.setData(Uri.parse("https://eportal.incometax.gov.in/iec/foservices/#/login"));
                startActivity(i5);
            }
        });

        ap13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(Intent.ACTION_VIEW);
                i4.setData(Uri.parse("https://appointments.uidai.gov.in/?AspxAutoDetectCookieSupport=1"));
                startActivity(i4);
            }
        });

        ap14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(Intent.ACTION_VIEW);
                i3.setData(Uri.parse("https://myaadhaar.uidai.gov.in/genricDownloadAadhaar"));
                startActivity(i3);
            }
        });

        ap15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse("https://myaadhaar.uidai.gov.in/CheckAadhaarStatus"));
                startActivity(i2);
            }
        });
    }
}