package com.example.mobilenumberlocator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class RechargePlans extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    ImageView back;
    Button btn_recharge;
    String name;
    String sname;
    int imgc;
    int imgs;
    String[] cardName={"Airtel","Jio","Vodafone","Idea"};
    int img[] = {R.drawable.airtel128, R.drawable.addresslocationtracker_s4, R.drawable.addresslocationtracker_vodafone128, R.drawable.idea128};


    String[] state = {"Assam","Bihar","Chennai","Delhi NCR","Gujarat","Himachal Pradesh","Hariyana","Jammu Kashmir"};
    int loc[] = {R.drawable.location,R.drawable.location,R.drawable.location,R.drawable.location,R.drawable.location,R.drawable.location,R.drawable.location,R.drawable.location};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_plans);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_recharge = findViewById(R.id.btn_recharge);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(RechargePlans.this);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(RechargePlans.this);

        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),img,cardName);
        spinner.setAdapter(customAdapter);

        CustomAdapter1 customAdapter1=new CustomAdapter1(getApplicationContext(),loc,state);
        spinner1.setAdapter(customAdapter1);

        btn_recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RechargePlans.this, Plans.class);

                // Step 5: add the values of the spinners as extras to the intent
                intent.putExtra("value1", name);
                intent.putExtra("value2", sname);

               startActivity(intent);
            }
        });

    }

    @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) { //Run Code For Major Spinner
            case R.id.spinner: {
                name = cardName[position];
                imgc = img[position];
            }
            case R.id.spinner1: {
                sname = state[position];
                imgs = loc[position];
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
//    @Override
//    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//
//
//
//
//
//    }

    }
