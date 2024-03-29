package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    TextView startbtn,privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startbtn = findViewById(R.id.startbtn);
        privacy = findViewById(R.id.privacy);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StartActivity.this,Language.class);
                startActivity(i);
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pri = new Intent(Intent.ACTION_VIEW);
                pri.setData(Uri.parse("https://freeprivacypolicyonline.com/Cubiova_Hub/privacy-policy.html"));
                startActivity(pri);
            }
        });
    }
}