package com.example.namestream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.Calendar;

import javax.xml.transform.Templates;

public class Register extends AppCompatActivity {

    TextView dateEdt;
    EditText fname,lname,age,quali,emailid,password1;
    CardView create;
    ImageView back;
    SharedPreferences pf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        age = findViewById(R.id.age);
        dateEdt = findViewById(R.id.dp);
        quali = findViewById(R.id.quali);
        emailid = findViewById(R.id.emailid);
        password1 = findViewById(R.id.password1);
        create = findViewById(R.id.create);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this,MainActivity.class);
                startActivity(i);
            }
        });

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.teal_700));

        dateEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateEdt.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name,name2,age1,date,education,mail,pass;

                name = fname.getText().toString();
                name2 = lname.getText().toString();
                age1 = age.getText().toString();
                date = dateEdt.getText().toString();
                education = quali.getText().toString();
                mail = emailid.getText().toString();
                pass = password1.getText().toString();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        //        String passwordPattern = "[A-Z][a-zA-Z]+[@#$^%&*][0-9]+";
                if(name.isEmpty()){
                    fname.setError("Please enter name");
                }else if(name.length() > 10 ){
                    fname.setError("Invalid User");
                }else if(name2.isEmpty()){
                    lname.setError("Please enter name");
                }else if(name2.length() > 15 ){
                    lname.setError("Invalid User");
                }else if (age1.isEmpty()){
                    age.setError("Please enter age");
                }else if(date.isEmpty()){
                    dateEdt.setError("Please select birth date");
                }else if(education.isEmpty()){
                    quali.setError("Please enter your qualification");
                }
                else if(mail.isEmpty()){
                    emailid.setError("Please enter the data");
                }else if(!mail.matches(emailPattern)){
                    emailid.setError("Invalid mail id");
                }
                else if(pass.isEmpty()){
                    password1.setError("Please enter password");
                }
//                else if(!pass.matches(passwordPattern)) {
//                    password1.setError("Invalid password");
                else {
                    pf = getSharedPreferences("credential",MODE_PRIVATE);
                    SharedPreferences.Editor ed = pf.edit();

                    ed.putString("register","done");
                    ed.putString("fname",fname.getText().toString());
                    ed.putString("lname",lname.getText().toString());
                    ed.putString("age",age.getText().toString());
                    ed.putString("dob",dateEdt.getText().toString());
                    ed.putString("quali",quali.getText().toString());
                    ed.putString("email",emailid.getText().toString());
                    ed.putString("passw",password1.getText().toString());
                    ed.apply();

                    Intent cr = new Intent(Register.this, Information.class);
                    startActivity(cr);
                    Toast.makeText(Register.this, "Your account is successfully created !", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}