package com.example.namestream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText mail,pass;
    CardView signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        signin = findViewById(R.id.signin);

        SharedPreferences sh = getSharedPreferences("credential", MODE_PRIVATE);

        String ma = sh.getString("email","");
        String pa = sh.getString("passw","");




        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("email",ma);

                String email = mail.getText().toString();
                String password = pass.getText().toString();

                if(email.equals("")){
                    mail.setError("Required");
                }else if(password.isEmpty()){
                    pass.setError("Required");
                }else if(email.equals(ma) && password.equals(pa)){
                    Intent intent = new Intent(Login.this,Success.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(Login.this, "Invaild User", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}



