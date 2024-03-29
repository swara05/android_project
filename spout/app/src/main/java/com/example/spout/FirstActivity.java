package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    Button valid,check,history;
    Button credit,intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        valid = findViewById(R.id.valid);
        check = findViewById(R.id.check);
        history = findViewById(R.id.history);
        credit = findViewById(R.id.credit);
        intro = findViewById(R.id.intro);

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(FirstActivity.this,CardValidity.class);
                startActivity(intent1);

            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ch = new Intent(FirstActivity.this,FreeBinCheck.class);
                startActivity(ch);
            }
        });

//        history.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });


        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent beni = new Intent(FirstActivity.this,CreditCardBenifit.class);
                startActivity(beni);
            }
        });

        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent into = new Intent(FirstActivity.this,Suess.class);
                startActivity(into);

            }
        });

    }
}