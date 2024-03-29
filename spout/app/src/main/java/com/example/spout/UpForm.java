package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpForm extends AppCompatActivity {

    Button arrowa2,nexta2;
    EditText state,country,zip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_form);

        arrowa2 = findViewById(R.id.arrowa2);
        nexta2 = findViewById(R.id.nexta2);
        state = findViewById(R.id.state);
        country = findViewById(R.id.country);
        zip = findViewById(R.id.zip);

        arrowa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arra2 = new Intent(UpForm.this,FillUp.class);
                startActivity(arra2);
            }
        });

        nexta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state.toString().isEmpty()){
                    state.setError("Please enter State name");
                }else if(country.toString().isEmpty()){
                    country.setError("Please enter country name");
                }else if(zip.toString().isEmpty()) {
                    zip.setError("Please enter zip code");
                }else{
                    Intent fill2 = new Intent(UpForm.this,Fill.class);
                    startActivity(fill2);
                }
            }
        });
    }
}