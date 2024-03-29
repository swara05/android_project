package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CardValidity extends AppCompatActivity {

    EditText edit1,edit2,edit3,edit4;

    Button butn,arrow3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_validity);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit4);
        butn = findViewById(R.id.butn);
        arrow3 = findViewById(R.id.arrow3);


        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit4.toString().isEmpty()){
                    Toast.makeText(CardValidity.this, "Please enter the card number.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CardValidity.this, "Credit Card is valid!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        arrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intet = new Intent(CardValidity.this,FirstActivity.class);
                startActivity(intet);
            }
        });

    }
}