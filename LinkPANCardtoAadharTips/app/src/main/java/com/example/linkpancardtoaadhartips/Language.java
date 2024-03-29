package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Language extends AppCompatActivity {

    ImageView btn;
    ImageView one,two,three,four,five,six;
    CardView eng,hin,ind,kor,jap,por;
    public  static String select = "eng";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        btn = findViewById(R.id.btn);
        eng = findViewById(R.id.eng);
        hin = findViewById(R.id.hin);
        ind = findViewById(R.id.ind);
        kor = findViewById(R.id.kor);
        jap = findViewById(R.id.jap);
        por = findViewById(R.id.por);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);


        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setImageResource(R.drawable.check2);
                two.setImageResource(R.drawable.checktrans);
                three.setImageResource(R.drawable.checktrans);
                four.setImageResource(R.drawable.checktrans);
                five.setImageResource(R.drawable.checktrans);
                six.setImageResource(R.drawable.checktrans);
            }
        });

        hin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setImageResource(R.drawable.checktrans);
                two.setImageResource(R.drawable.check2);
                three.setImageResource(R.drawable.checktrans);
                four.setImageResource(R.drawable.checktrans);
                five.setImageResource(R.drawable.checktrans);
                six.setImageResource(R.drawable.checktrans);
            }
        });

        ind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setImageResource(R.drawable.checktrans);
                two.setImageResource(R.drawable.checktrans);
                three.setImageResource(R.drawable.check2);
                four.setImageResource(R.drawable.checktrans);
                five.setImageResource(R.drawable.checktrans);
                six.setImageResource(R.drawable.checktrans);
            }
        });

        kor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setImageResource(R.drawable.checktrans);
                two.setImageResource(R.drawable.checktrans);
                three.setImageResource(R.drawable.checktrans);
                four.setImageResource(R.drawable.check2);
                five.setImageResource(R.drawable.checktrans);
                six.setImageResource(R.drawable.checktrans);
            }
        });

        jap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setImageResource(R.drawable.checktrans);
                two.setImageResource(R.drawable.checktrans);
                three.setImageResource(R.drawable.checktrans);
                four.setImageResource(R.drawable.checktrans);
                five.setImageResource(R.drawable.check2);
                six.setImageResource(R.drawable.checktrans);
            }
        });

        por.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setImageResource(R.drawable.checktrans);
                two.setImageResource(R.drawable.checktrans);
                three.setImageResource(R.drawable.checktrans);
                four.setImageResource(R.drawable.checktrans);
                five.setImageResource(R.drawable.checktrans);
                six.setImageResource(R.drawable.check2);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent bt = new Intent(Language.this,MainActivity.class);
                startActivity(bt);

            }
        });

    }
}