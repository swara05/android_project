package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CardProcess extends AppCompatActivity {

    Button arrow7,apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_process);

        arrow7 = findViewById(R.id.arrow7);
        apply = findViewById(R.id.apply);

        arrow7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arr7 = new Intent(CardProcess.this,CreditCardBenifit.class);
                startActivity(arr7);
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent app = new Intent(CardProcess.this,EligibilityCriteria.class);
                    startActivity(app);
            }
        });
    }
}