package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PanPeLoan extends AppCompatActivity {

    ImageView pastbtn;
    TextView pan1,pan2,pan3,pan4,pan5,pan6,pan7,pan8,pan9,pan10;
    TextView pan11,pan12,pan13,pan14,pan15,pan16,pan17,pan18,pan19,pan20,pan21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan_pe_loan);

        pastbtn = findViewById(R.id.pastbtn);
        pan1 = findViewById(R.id.pan1);
        pan2 = findViewById(R.id.pan2);
        pan3 = findViewById(R.id.pan3);
        pan4 = findViewById(R.id.pan4);
        pan5 = findViewById(R.id.pan5);
        pan6 = findViewById(R.id.pan6);
        pan7 = findViewById(R.id.pan7);
        pan8 = findViewById(R.id.pan8);
        pan9 = findViewById(R.id.pan9);
        pan10 = findViewById(R.id.pan10);
        pan11 = findViewById(R.id.pan11);
        pan12 = findViewById(R.id.pan12);
        pan13 = findViewById(R.id.pan13);
        pan14 = findViewById(R.id.pan14);
        pan15 = findViewById(R.id.pan15);
        pan16 = findViewById(R.id.pan16);
        pan17 = findViewById(R.id.pan17);
        pan18 = findViewById(R.id.pan18);
        pan19 = findViewById(R.id.pan19);
        pan20 = findViewById(R.id.pan20);
        pan21 = findViewById(R.id.pan21);

        pastbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        pan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p1 = new Intent(PanPeLoan.this,PpeLoan1.class);
                startActivity(p1);
            }
        });

        pan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p2 = new Intent(PanPeLoan.this,PpeLoan2.class);
                startActivity(p2);
            }
        });

        pan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p3 = new Intent(PanPeLoan.this,PpeLoan3.class);
                startActivity(p3);
            }
        });

        pan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p4 = new Intent(PanPeLoan.this,PpeLoan4.class);
                startActivity(p4);
            }
        });

        pan5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p5 = new Intent(PanPeLoan.this,PpeLoan5.class);
                startActivity(p5);
            }
        });

        pan6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p6 = new Intent(PanPeLoan.this,PpeLoan6.class);
                startActivity(p6);
            }
        });

        pan7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p7 = new Intent(PanPeLoan.this,PpeLoan7.class);
                startActivity(p7);
            }
        });

        pan8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p8 = new Intent(PanPeLoan.this,PpeLoan8.class);
                startActivity(p8);
            }
        });

        pan9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p9 = new Intent(PanPeLoan.this,PpeLoan9.class);
                startActivity(p9);
            }
        });

        pan10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p10 = new Intent(PanPeLoan.this,PpeLoan10.class);
                startActivity(p10);
            }
        });

        pan11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p11 = new Intent(PanPeLoan.this,PpeLoan11.class);
                startActivity(p11);
            }
        });

        pan12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p12 = new Intent(PanPeLoan.this,PpeLoan12.class);
                startActivity(p12);
            }
        });

        pan13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p13 = new Intent(PanPeLoan.this,PpeLoan13.class);
                startActivity(p13);
            }
        });


        pan14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p14 = new Intent(PanPeLoan.this,PpeLoan14.class);
                startActivity(p14);
            }
        });

        pan15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p15 = new Intent(PanPeLoan.this,PpeLoan15.class);
                startActivity(p15);
            }
        });

        pan16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p16 = new Intent(PanPeLoan.this,PpeLoan16.class);
                startActivity(p16);
            }
        });

        pan17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p17 = new Intent(PanPeLoan.this,PpeLoan17.class);
                startActivity(p17);
            }
        });

        pan18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p18 = new Intent(PanPeLoan.this,PpeLoan18.class);
                startActivity(p18);
            }
        });

        pan19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p19 = new Intent(PanPeLoan.this,PpeLoan19.class);
                startActivity(p19);
            }
        });

        pan20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p20 = new Intent(PanPeLoan.this,PpeLoan20.class);
                startActivity(p20);
            }
        });

        pan21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p21 = new Intent(PanPeLoan.this,PpeLoan21.class);
                startActivity(p21);
            }
        });


    }
}