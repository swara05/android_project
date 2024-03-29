
package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AadharToStore extends AppCompatActivity {

    ImageView i1;
    TextView step1,step2,step3,step4,step5,step6,step7,step8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar_to_store);

        i1 = findViewById(R.id.i1);
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step3 = findViewById(R.id.step3);
        step4 = findViewById(R.id.step4);
        step5 = findViewById(R.id.step5);
        step6 = findViewById(R.id.step6);
        step7 = findViewById(R.id.step7);
        step8 = findViewById(R.id.step8);


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s1 = new Intent(AadharToStore.this,Store1.class);
                startActivity(s1);
            }
        });

        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s2 = new Intent(AadharToStore.this,Store2.class);
                startActivity(s2);
            }
        });

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s3 = new Intent(AadharToStore.this,Store3.class);
                startActivity(s3);
            }
        });

        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s4 = new Intent(AadharToStore.this,Store4.class);
                startActivity(s4);
            }
        });
        step5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s5 = new Intent(AadharToStore.this,Store5.class);
                startActivity(s5);
            }
        });

        step6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s6 = new Intent(AadharToStore.this,Store6.class);
                startActivity(s6);
            }
        });

        step7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s7 = new Intent(AadharToStore.this,Store7.class);
                startActivity(s7);
            }
        });

        step8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s8 = new Intent(AadharToStore.this,Store8.class);
                startActivity(s8);
            }
        });


    }
}