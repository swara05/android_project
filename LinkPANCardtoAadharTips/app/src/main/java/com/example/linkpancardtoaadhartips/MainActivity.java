package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout adharpan,adharnumber,panloan,adharloan,loancal;
    TextView appname,card1,card2,card3,card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        loancal = findViewById(R.id.loancal);
        adharpan = findViewById(R.id.adharpan);
        adharnumber = findViewById(R.id.adharnumber);
        panloan = findViewById(R.id.panloan);
        adharloan = findViewById(R.id.adharloan);
        appname = findViewById(R.id.appname);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);

//        if(Language.select.contains("eng")){
//
//            card1.setText(R.string.aadharcard_to_pan_link);
//            card2.setText(R.string.aadhar_to_number_link);
//            card3.setText(R.string.pancard_pe_loan);
//            card4.setText(R.string.aadhar_pe_loan);
//            appname.setText(R.string.app_name);
//
//        }else{
//            card1.setText(R.string.card_1);
//            card2.setText(R.string.card_2);
//            card3.setText(R.string.card_3);
//            card4.setText(R.string.card_4);
//            appname.setText(R.string.app_hindi);
//        }

        adharpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aadharpan = new Intent(MainActivity.this,AadharToPan.class);
                startActivity(aadharpan);
            }
        });

        adharnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aadharnum = new Intent(MainActivity.this,AadharToNumber.class);
                startActivity(aadharnum);
            }
        });

        panloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pan = new Intent(MainActivity.this,PanPeLoan.class);
                startActivity(pan);
            }
        });

        adharloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aadharloan = new Intent(MainActivity.this,AadharPeLoan.class);
                startActivity(aadharloan);
            }
        });

        loancal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoanCalculator.class);
                startActivity(intent);
            }
        });
    }
}