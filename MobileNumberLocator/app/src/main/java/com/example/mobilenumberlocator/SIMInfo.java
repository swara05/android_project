package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SIMInfo extends AppCompatActivity {

    ImageView back;
    Button btn_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siminfo);

        back = findViewById(R.id.back);
        btn_next = findViewById(R.id.btn_next);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent lc = new Intent(SIMInfo.this,SimList.class);
                startActivity(lc);
            }
        });


    }
}