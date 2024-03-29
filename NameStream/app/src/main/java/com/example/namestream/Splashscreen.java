package com.example.namestream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent sp = new Intent(Splashscreen.this,MainActivity.class);
                startActivity(sp);
                finish();
            }
        },5*1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences admob = getSharedPreferences("credential", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = admob.edit();
        editor.clear();
        editor.apply();

    }
}