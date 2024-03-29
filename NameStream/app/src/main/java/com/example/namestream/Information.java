package com.example.namestream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Information extends AppCompatActivity {

    TextView tv;
    CardView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        tv = findViewById(R.id.tv);
        signin = findViewById(R.id.signin);

        SharedPreferences sh = getSharedPreferences("credential", MODE_PRIVATE);

        String fn = sh.getString("fname","");
        String ln = sh.getString("lname","");
        String ag = sh.getString("age","");
        String edu = sh.getString("quali","");
        String date = sh.getString("dob","");
        String ma = sh.getString("email","");
        String pa = sh.getString("passw","");



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String register = sh.getString("register","");

                SharedPreferences.Editor ed = sh.edit();
                ed.putString("register",register);
                ed.apply();

                Intent cr = new Intent(Information.this, MainActivity.class);
                startActivity(cr);

            }
        });

        tv.setText("First Name: "+fn+"\n\nLast Name: "+ln+"\n\nAge: "+ag+"\n\nDate Of Birth: "+date+"\n\nQualification :"+edu+"\n\nE-mail ID:"+ma+"\n\nPassword: "+pa);
    }
}

