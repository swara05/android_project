package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FillUp extends AppCompatActivity {

    Button arrowa1,nexta1;
    EditText apart,add,city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_up);

        arrowa1 = findViewById(R.id.arrowa1);
        nexta1 = findViewById(R.id.nexta1);
        apart = findViewById(R.id.apart);
        add = findViewById(R.id.add);
        city = findViewById(R.id.city);

        arrowa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arra1 = new Intent(FillUp.this,FormFill.class);
                startActivity(arra1);
            }
        });

        nexta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(apart.toString().isEmpty()){
                   apart.setError("Please enter Suite No.");
                }else if(add.toString().isEmpty()){
                    add.setError("Please enter address");
                }else if(city.toString().isEmpty()) {
                    city.setError("Please enter city");
                }else{
                    Intent fill1 = new Intent(FillUp.this,UpForm.class);
                    startActivity(fill1);
                }
            }
        });
    }
}