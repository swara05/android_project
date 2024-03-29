package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FieldActivity extends AppCompatActivity {

    CardView success,confidence,abundance,selfesteem,mentalhealth,love,relationship,friendship,family,happiness,
    mindfulness,decisionmaking,personalgrowth,physicalhealth,social,woman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        success = findViewById(R.id.success);
        confidence = findViewById(R.id.confidence);
        abundance = findViewById(R.id.abundance);
        selfesteem = findViewById(R.id.selfsteem);
        mentalhealth = findViewById(R.id.mentalhealth);
        love = findViewById(R.id.love);
        relationship = findViewById(R.id.relationship);
        friendship = findViewById(R.id.friendship);
        family = findViewById(R.id.family);
        happiness = findViewById(R.id.happiness);
        mindfulness = findViewById(R.id.mindfulness);
        decisionmaking = findViewById(R.id.decisionmaking);
        personalgrowth = findViewById(R.id.personalgrowth);
        physicalhealth = findViewById(R.id.physicalhealth);
        social = findViewById(R.id.social);
        woman = findViewById(R.id.woman);

        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Success");
                startActivity(i);
            }
        });

        confidence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Confidence");
                startActivity(i);
            }
        });

        selfesteem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Self Esteem");
                startActivity(i);
            }
        });

        abundance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Abundance");
                startActivity(i);
            }
        });

        mentalhealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Mental Health");
                startActivity(i);
            }
        });

       relationship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Relationship");
                startActivity(i);
            }
        });

        friendship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Friendship");
                startActivity(i);
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Love");
                startActivity(i);
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Family");
                startActivity(i);
            }
        });

        happiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Happiness");
                startActivity(i);
            }
        });

        mindfulness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Mindfulness");
                startActivity(i);
            }
        });

        decisionmaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Decision Making");
                startActivity(i);
            }
        });

        personalgrowth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Personal Growth");
                startActivity(i);
            }
        });

        physicalhealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Physical Health");
                startActivity(i);
            }
        });

        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Social");
                startActivity(i);
            }
        });

       woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FieldActivity.this,MainActivity.class);
                i.putExtra("name","Woman");
                startActivity(i);
            }
        });

    }
}

