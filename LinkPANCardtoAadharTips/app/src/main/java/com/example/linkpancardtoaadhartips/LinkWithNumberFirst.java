package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LinkWithNumberFirst extends AppCompatActivity {

    ImageView back;
    TextView step1,step2,step3,step4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_with_number_first);

        back = findViewById(R.id.back);
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step3 = findViewById(R.id.step3);
        step4 = findViewById(R.id.step4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s1 = new Intent(LinkWithNumberFirst.this,Num1Step1.class);
                startActivity(s1);
            }
        });

        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s2 = new Intent(LinkWithNumberFirst.this,Num1Step2.class);
                startActivity(s2);
            }
        });

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s3 = new Intent(LinkWithNumberFirst.this,Num1Step3.class);
                startActivity(s3);
            }
        });

        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s4 = new Intent(LinkWithNumberFirst.this,Num1Step4.class);
                startActivity(s4);
            }
        });
    }
}