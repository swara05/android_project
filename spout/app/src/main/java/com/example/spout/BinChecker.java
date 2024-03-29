package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BinChecker extends AppCompatActivity {

    Button arrow5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bin_checker);

        arrow5 = findViewById(R.id.arrow5);

        arrow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bin = new Intent(BinChecker.this,FreeBinCheck.class);
                startActivity(bin);
            }
        });
    }
}