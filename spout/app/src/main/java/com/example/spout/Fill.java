package com.example.spout;

import static java.util.Calendar.DAY_OF_MONTH;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Calendar;

public class Fill extends AppCompatActivity {

     Button arrowa3,nexta3,cal;
    final Calendar calen= Calendar.getInstance();
     EditText date1,mail;
     RadioGroup radiog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);
        arrowa3 = findViewById(R.id.arrowa3);
        nexta3 = findViewById(R.id.nexta3);
        cal = findViewById(R.id.cal);
        date1 = findViewById(R.id.date1);
        radiog = findViewById(R.id.radiog);
        mail = findViewById(R.id.mail);

        arrowa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arr3 = new Intent(Fill.this,UpForm.class);
                startActivity(arr3);
            }
        });

        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calen.set(Calendar.YEAR, year);
                calen.set(Calendar.MONTH,month);
                calen.set(DAY_OF_MONTH,day);
                date1.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
            }
        };

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Fill.this,date,calen.get(Calendar.YEAR),calen.get(Calendar.MONTH),calen.get(DAY_OF_MONTH))
                        .show();
            }
        });


       nexta3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(mail.toString().isEmpty()){
                   mail.setError("Please Enter Mail Id");
               }else if(!Patterns.EMAIL_ADDRESS.matcher(mail.getText().toString()).matches()){
                   mail.setError("Enter valid format");
               }

               Intent succ = new Intent(Fill.this,Suess.class);
               startActivity(succ);
           }
       });
    }
}