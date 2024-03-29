package com.example.cognizant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Final extends AppCompatActivity {

    ImageView pics;
    TextView line,order,cancel,done,detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        pics = findViewById(R.id.pics);
        line = findViewById(R.id.line);
        order = findViewById(R.id.order);
        detail = findViewById(R.id.detail);

        pics.setImageResource(getIntent().getIntExtra("fpic",0));
        line.setText(getIntent().getStringExtra("fname"));
        detail.setText(getIntent().getStringExtra("fdesc"));

        Dialog dialog = new Dialog(Final.this);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.setContentView(R.layout.dialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);


                done = dialog.findViewById(R.id.done);
                cancel = dialog.findViewById(R.id.cancel);

                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(Final.this, "Successfully Purchase.", Toast.LENGTH_SHORT).show();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(Final.this, "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();

            }
        });
    }
}