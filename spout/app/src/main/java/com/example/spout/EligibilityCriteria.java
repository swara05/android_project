package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EligibilityCriteria extends AppCompatActivity {

    Button arrow8,next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility_criteria);

        arrow8 = findViewById(R.id.arrow8);
        next1 = findViewById(R.id.next1);

        arrow8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent arr8 = new Intent(EligibilityCriteria.this,CardProcess.class);
                startActivity(arr8);
            }
        });

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent doc = new Intent(EligibilityCriteria.this,DocumentRequired.class);
                startActivity(doc);
            }
        });
    }
}