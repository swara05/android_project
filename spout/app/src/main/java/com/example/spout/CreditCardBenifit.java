package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreditCardBenifit extends AppCompatActivity {

    Button arrow6,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_benifit);

        arrow6 = findViewById(R.id.arrow6);

        arrow6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arr6 = new Intent(CreditCardBenifit.this,FirstActivity.class);
                startActivity(arr6);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nex = new Intent(CreditCardBenifit.this,CardProcess.class);
                startActivity(nex);
            }
        });
    }
}