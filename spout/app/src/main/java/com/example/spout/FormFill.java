package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormFill extends AppCompatActivity {

    Button arrowa,nexta;
    EditText fname,mname,lname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fill);

        arrowa = findViewById(R.id.arrowa);
        nexta = findViewById(R.id.nexta);
        fname = findViewById(R.id.fname);
        mname = findViewById(R.id.mname);
        lname = findViewById(R.id.lname);

        arrowa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arra = new Intent(FormFill.this,FirstActivity.class);
                startActivity(arra);
            }
        });

        nexta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(fname.toString().isEmpty()){
                    fname.setError("Please enter First Name");
                }else if(mname.toString().isEmpty()){
                    mname.setError("Enter your middle name");
                }else if(lname.toString().isEmpty()) {
                    lname.setError("Enter your last name");
                }else{
                    Intent fill = new Intent(FormFill.this,FillUp.class);
                    startActivity(fill);
                }

            }
        });



    }
}