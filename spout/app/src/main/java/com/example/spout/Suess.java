package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Suess extends AppCompatActivity {

    Button arrowa4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suess);
        arrowa4 = findViewById(R.id.arrowa4);

        arrowa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent success = new Intent(Suess.this,FirstActivity.class);
                startActivity(success);
            }
        });
    }
}