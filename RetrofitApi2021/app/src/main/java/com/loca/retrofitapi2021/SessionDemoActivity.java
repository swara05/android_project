package com.loca.retrofitapi2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loca.retrofitapi2021.Utils.Global;

public class SessionDemoActivity extends AppCompatActivity {

    private TextView name,age,study,number,city;
    Button done ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_demo);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        study = findViewById(R.id.study);
        number = findViewById(R.id.number);
        city = findViewById(R.id.city);
        done = findViewById(R.id.done);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Global.set_name(name.getText().toString());
                Global.set_age(age.getText().toString());
                Global.set_study(study.getText().toString());
                Global.set_number(number.getText().toString());
                Global.set_city(city.getText().toString());

                Intent intent = new Intent(SessionDemoActivity.this,ShowSessionActivity.class);
                startActivity(intent);
            }
        });


    }
}