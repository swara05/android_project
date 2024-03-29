package com.example.spout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DocumentRequired extends AppCompatActivity {

    Button arrow9,next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_required);

        arrow9 = findViewById(R.id.arrow9);
        next2 = findViewById(R.id.next2);

        arrow9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arr9 = new Intent(DocumentRequired.this,EligibilityCriteria.class);
                startActivity(arr9);
            }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent net = new Intent(DocumentRequired.this,FormFill.class);
                startActivity(net);
            }
        });
    }
}