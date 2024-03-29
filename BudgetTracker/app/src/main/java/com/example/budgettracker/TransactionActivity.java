package com.example.budgettracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class TransactionActivity extends AppCompatActivity {
    RecyclerView recycle;
    //    int id[] = {R.id.a1,"a2","a3","a4","a5","a6","a7","a8","a9","a10","a11","a12","a13","a14","a15","a16","a17","a18"};
    ImageView back;
    int a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        recycle = findViewById(R.id.recycle);
        back = findViewById(R.id.back);

        Database database = new Database(TransactionActivity.this);
        List<StdData> dataList = database.RetriveData();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(TransactionActivity.this);
        ReAdapter adapter = new ReAdapter(TransactionActivity.this, dataList, a, b, c);
        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapter);
//        MainActivity.income_amount.setText(a);
//        MainActivity.expense_amount.setText(b);
//        MainActivity.balance.setText(c);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}