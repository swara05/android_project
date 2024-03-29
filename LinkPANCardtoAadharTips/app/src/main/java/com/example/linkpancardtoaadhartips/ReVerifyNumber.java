package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ReVerifyNumber extends AppCompatActivity {

    ImageView back1;
    TextView step1,step2,step3,step4,step5,step6,step7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_verify_number);

        back1 = findViewById(R.id.back1);
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step3 = findViewById(R.id.step3);
        step4 = findViewById(R.id.step4);
        step5 = findViewById(R.id.step5);
        step6 = findViewById(R.id.step6);
        step7 = findViewById(R.id.step7);

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r1 = new Intent(ReVerifyNumber.this,ReStep1.class);
                startActivity(r1);
            }
        });

        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r2 = new Intent(ReVerifyNumber.this,ReStep2.class);
                startActivity(r2);
            }
        });

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r3 = new Intent(ReVerifyNumber.this,ReStep3.class);
                startActivity(r3);
            }
        });

        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r4 = new Intent(ReVerifyNumber.this,ReStep4.class);
                startActivity(r4);
            }
        });


        step5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r5 = new Intent(ReVerifyNumber.this,ReStep5.class);
                startActivity(r5);
            }
        });
        step6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r6 = new Intent(ReVerifyNumber.this,ReStep6.class);
                startActivity(r6);
            }
        });
        step7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r7 = new Intent(ReVerifyNumber.this,ReStep7.class);
                startActivity(r7);
            }
        });


    }
}