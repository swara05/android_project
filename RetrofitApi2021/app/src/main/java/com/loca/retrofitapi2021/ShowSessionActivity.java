package com.loca.retrofitapi2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loca.retrofitapi2021.Utils.Global;

public class ShowSessionActivity extends AppCompatActivity {

    private TextView txt_name,txt_age, txt_city, txt_number,txt_study;
    private Button txt_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_session);

        txt_name = findViewById(R.id.txt_name);
        txt_age = findViewById(R.id.txt_age);
        txt_city = findViewById(R.id.txt_city);
        txt_number = findViewById(R.id.txt_number);
        txt_study = findViewById(R.id.txt_study);
        txt_go = findViewById(R.id.txt_go);


        txt_name.setText(Global.get_name());
        txt_age.setText(Global.get_age());
        txt_city.setText(Global.get_city());
        txt_number.setText(Global.get_number());
        txt_study.setText(Global.get_study());

        txt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowSessionActivity.this,SessionDemoActivity.class);
                startActivity(intent);
            }
        });
    }
}