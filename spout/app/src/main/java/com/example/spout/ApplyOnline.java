package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ApplyOnline extends AppCompatActivity {

    Button arrowa5;
    EditText edit1,edit2,edit3,edit4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_online);
        arrowa5 = findViewById(R.id.arrowa5);
        arrowa5 = findViewById(R.id.arrowa5);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit4);

        edit1.setText("8569");
        edit2.setText("4253");
        edit3.setText("4698");
        edit4.setText("2436");


        arrowa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(ApplyOnline.this,FirstActivity.class);
                startActivity(info);
            }
        });

    }
}