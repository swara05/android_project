package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class USSDCodes extends AppCompatActivity {


    ImageView back;
    ImageView airtel,idea,vodafone,jio,bsnl,docomo,uninor;
    // final String TAG = "data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ussdcodes);

        back = findViewById(R.id.back);
        airtel = findViewById(R.id.airtel);
        idea = findViewById(R.id.idea);
        vodafone = findViewById(R.id.vodafone);
        jio = findViewById(R.id.jio);
        bsnl = findViewById(R.id.bsnl);
        docomo = findViewById(R.id.docomo);
        uninor = findViewById(R.id.uninor);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        airtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(USSDCodes.this,USSDDetails.class);
                i.putExtra("sim","airtel");
                startActivity(i);
            }
        });

        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(USSDCodes.this,USSDDetails.class);
                i.putExtra("sim","idea");
                startActivity(i);
            }
        });

        vodafone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(USSDCodes.this,USSDDetails.class);
                i.putExtra("sim","vodafone");
                startActivity(i);
            }
        });

        jio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(USSDCodes.this,USSDDetails.class);
                i.putExtra("sim","jio");
                startActivity(i);
            }
        });

        bsnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(USSDCodes.this,USSDDetails.class);
                i.putExtra("sim","bsnl");
                startActivity(i);
            }
        });


        docomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(USSDCodes.this,USSDDetails.class);
                i.putExtra("sim","docomo");
                startActivity(i);
            }
        });

        uninor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(USSDCodes.this,USSDDetails.class);
                i.putExtra("sim","uninor");
                startActivity(i);
            }
        });

    }


}