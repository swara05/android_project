package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Step2 extends AppCompatActivity {

    Button arrow,next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        next1 = findViewById(R.id.next1);
        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nex = new Intent(Step2.this,ApplyForCredit.class);
                startActivity(nex);
            }
        });


       next1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                Intent arr = new Intent(Step2.this,Step3.class);
                startActivity(arr);
           }
       });
    }
}