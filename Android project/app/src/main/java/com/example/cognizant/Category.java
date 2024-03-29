package com.example.cognizant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Category extends AppCompatActivity {

    CardView clothes,grocery,bags,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        clothes = findViewById(R.id.clothes);
        grocery = findViewById(R.id.grocery);
        bags = findViewById(R.id.bags);
        mobile = findViewById(R.id.mobile);

        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cl = new Intent(Category.this,Clothes.class);
                startActivity(cl);
            }
        });

        grocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gr = new Intent(Category.this,Grocery.class);
                startActivity(gr);
            }
        });

        bags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bag = new Intent(Category.this,Bags.class);
                startActivity(bag);
            }
        });

       mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mo = new Intent(Category.this,Mobile.class);
                startActivity(mo);
            }
        });
    }
}