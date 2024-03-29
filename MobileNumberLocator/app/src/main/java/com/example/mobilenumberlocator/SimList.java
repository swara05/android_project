package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SimList extends AppCompatActivity {

    ImageView back;
    ImageView airtel,aircel,idea,vodafone,jio,bsnl,docomo,uninor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_list);

        back = findViewById(R.id.back);
        airtel = findViewById(R.id.airtel);
        idea = findViewById(R.id.idea);
        vodafone = findViewById(R.id.vodafone);
        jio = findViewById(R.id.jio);
        bsnl = findViewById(R.id.bsnl);
        docomo = findViewById(R.id.docomo);
        uninor = findViewById(R.id.uninor);
        aircel = findViewById(R.id.aircel);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        airtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SimList.this,SIMDetails.class);
                i.putExtra("card","airtel");
                startActivity(i);
            }
        });
        
        aircel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SimList.this,SIMDetails.class);
                i.putExtra("card","aircel");
                startActivity(i);
            }
        });

        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SimList.this,SIMDetails.class);
                i.putExtra("card","idea");
                startActivity(i);
            }
        });

        vodafone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SimList.this,SIMDetails.class);
                i.putExtra("card","vodafone");
                startActivity(i);
            }
        });

        jio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SimList.this,SIMDetails.class);
                i.putExtra("card","jio");
                startActivity(i);
            }
        });

        bsnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SimList.this,SIMDetails.class);
                i.putExtra("card","bsnl");
                startActivity(i);
            }
        });


        docomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SimList.this,SIMDetails.class);
                i.putExtra("card","docomo");
                startActivity(i);
            }
        });

        uninor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SimList.this,SIMDetails.class);
                i.putExtra("card","uninor");
                startActivity(i);
            }
        });

    }
}