package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Step3 extends AppCompatActivity {

    Button arrow1,next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);

        arrow1 = findViewById(R.id.arrow1);
        next2 = findViewById(R.id.next2);
        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nex = new Intent(Step3.this,Step2.class);
                startActivity(nex);
            }
        });


        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arr = new Intent(Step3.this,FirstActivity.class);
                startActivity(arr);
            }
        });
    }
}