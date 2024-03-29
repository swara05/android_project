package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class cat extends AppCompatActivity {
    RecyclerView recyclerView;
    List<StdData> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        recyclerView = findViewById(R.id.recycle);
        Exdatabase exdatabase = new Exdatabase(cat.this);
        List<StdData> dataList = exdatabase.Retivedata();
        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(cat.this));
        Intent intent = getIntent();

        String a = intent.getStringExtra("morning");
        if (a.matches("Good Morning")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.matches(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.matches("Good Night")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.matches(a)) {
                    datas.add(dataList.get(j));
                }
            }
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.matches("Birthday")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.matches("Love")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.matches("Friendship")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Attitude")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Funny")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Romantic")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Best Wishes")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("God")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Yaad")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Other")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Ganesha")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Navratri")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("New Year")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("All In One")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase(a)) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Kite")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Republic")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Valentine Special")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }
        if (a.equalsIgnoreCase("Holi")) {
            datas.clear();
            for (int j = 0; j < dataList.size(); j++) {
                String store = dataList.get(j).cate;
                if (store.equalsIgnoreCase(a)) {
                    datas.add(dataList.get(j));
                }
            }
            int k = intent.getIntExtra("size", -1);
            recyclerView.setAdapter(new ReAdapter(cat.this, datas));
        }


    }

}
