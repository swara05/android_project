package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Locator extends AppCompatActivity {

    ImageView back;
    TextView btn_loc,btn_std,btn_isd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);

        back = findViewById(R.id.back);
        btn_loc = findViewById(R.id.btn_loc);
        btn_std = findViewById(R.id.btn_std);
        btn_isd = findViewById(R.id.btn_isd);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Locator.this,CounrtyCode.class);
                startActivity(c);
            }
        });

        btn_std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Locator.this,STDCodes.class);
                startActivity(c);
            }
        });

        btn_isd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Locator.this,ISDCodes.class);
                startActivity(c);
            }
        });

    }
}