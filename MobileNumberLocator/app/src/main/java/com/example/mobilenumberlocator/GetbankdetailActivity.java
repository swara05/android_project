package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Objects;

public class GetbankdetailActivity extends AppCompatActivity {

    private ImageView bankimg;
    private TextView bankname;
    private TextView balance;
    private TextView custcare;
    private TextView statement;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getbankdetail);

        bankimg = findViewById(R.id.bankimg);
        bankname = findViewById(R.id.bankname);
        balance = findViewById(R.id.balance);
        custcare = findViewById(R.id.custcare);
        statement = findViewById(R.id.statement);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String bal = intent.getStringExtra("balance");
        String care = intent.getStringExtra("custnum");
        String min = intent.getStringExtra("minstate");
        int img = intent.getIntExtra("image", 0);

        bankname.setText(name);
        balance.setText(bal);
        custcare.setText(care);
        statement.setText(min);
        bankimg.setImageResource(img);

    }
}