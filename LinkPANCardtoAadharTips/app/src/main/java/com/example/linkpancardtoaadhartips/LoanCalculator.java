package com.example.linkpancardtoaadhartips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class LoanCalculator extends AppCompatActivity {

    EditText lamount,lrate,lperiod;
    TextView reset,calculate,temi,trate,tpay;
    ImageView cal;
    float p,ra,n;
    CardView card;

    private static final DecimalFormat decfor = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);


        temi = findViewById(R.id.temi);
        trate = findViewById(R.id.trate);
        tpay = findViewById(R.id.tpay);
        card = findViewById(R.id.card);
        lamount = findViewById(R.id.lamount);
        lrate = findViewById(R.id.lrate);
        lperiod = findViewById(R.id.lperiod);
        reset = findViewById(R.id.reset);
        calculate = findViewById(R.id.calculate);
        cal = findViewById(R.id.cal);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lamount.setText("");
                lrate.setText("");
                lperiod.setText("");
                card.setVisibility(View.GONE);

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String amount,rate,month;
                float emi,r,n1,d1,tint,tpayment;



                amount = lamount.getText().toString();
                rate = lrate.getText().toString();
                month = lperiod.getText().toString();

                p = Float.parseFloat(amount);
                ra = Float.parseFloat(rate);
                n = Float.parseFloat(month);

                if(amount.isEmpty()){
                    Toast.makeText(LoanCalculator.this, "Enter Loan Amount", Toast.LENGTH_SHORT).show();
                }else if(rate.isEmpty()){
                    Toast.makeText(LoanCalculator.this, "Enter Interest Amount", Toast.LENGTH_SHORT).show();
                }else if(month.isEmpty()){
                    Toast.makeText(LoanCalculator.this, "Enter Loan Period", Toast.LENGTH_SHORT).show();
                }else{
                    r = ra/12/100;
                    n1 = (float) Math.pow(1+r,n);
                    d1 = n1 -1;
                   // P x R x (1+R)^N / [(1+R)^N-1]
                    emi = p*r*n1/d1;
                    tpayment = emi * n;
                    tint = tpayment - p;
                    decfor.setRoundingMode(RoundingMode.UP);
                    card.setVisibility(View.VISIBLE);
                    temi.setText(decfor.format(emi) +" ₹ ");
                    trate.setText(decfor.format(tint) +" ₹ ");
                    tpay.setText(decfor.format(tpayment) +" ₹ ");
                }

            }
        });
    }
}