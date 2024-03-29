package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FreeBinCheck extends AppCompatActivity {

    Button cont,arrow4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_bin_check);

        cont = findViewById(R.id.cont);
        arrow4 = findViewById(R.id.arrow4);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent check = new Intent(FreeBinCheck.this,BinChecker.class);
                    startActivity(check);
            }
        });

        arrow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(FreeBinCheck.this,FirstActivity.class);
                startActivity(inte);
            }
        });

    }
}