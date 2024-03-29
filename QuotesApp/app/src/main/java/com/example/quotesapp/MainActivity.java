package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView morning, night, birthday, love, friend, attitude, funny, romantic, wish, god, yaad,
            other, ganesha, navratri, new_year, all_in_one, christmas, kite, republic, valentine, holi, demo;
    int k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Exdatabase exdatabase = new Exdatabase(MainActivity.this);
//        getWindow().setStatusBarColor(Color.TRANSPARENT);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
        List<StdData> dataList = exdatabase.Retivedata();
        recyclerView = findViewById(R.id.recycle);
        morning = findViewById(R.id.morning);
        night = findViewById(R.id.night);
        birthday = findViewById(R.id.birthday);
        love = findViewById(R.id.love);
        friend = findViewById(R.id.friend);
        attitude = findViewById(R.id.attitude);
        funny = findViewById(R.id.funny);
        romantic = findViewById(R.id.romantic);
        wish = findViewById(R.id.wish);
        god = findViewById(R.id.god);
        yaad = findViewById(R.id.yaad);
        other = findViewById(R.id.other);
        ganesha = findViewById(R.id.ganesha);
        navratri = findViewById(R.id.navratri);
        new_year = findViewById(R.id.new_year);
        all_in_one = findViewById(R.id.all_in_one);
        christmas = findViewById(R.id.christmas);
        kite = findViewById(R.id.kite);
        republic = findViewById(R.id.republid);
        valentine = findViewById(R.id.valentine);
        holi = findViewById(R.id.holi);
        demo = findViewById(R.id.demo);
        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Good Morning";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.matches(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
                k = 0;
            }
        });
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Good Night";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
                k = 0;
            }
        });
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Birthday";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Love";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Friendship";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        attitude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Attitude";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        funny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Funny";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        romantic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Romantic";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Best Wishes";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        god.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "God";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        yaad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Yaad";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Other";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        ganesha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Ganesha";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        navratri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Navratri";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        new_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "New Year";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        all_in_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "All In One";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        christmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Christmas";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        kite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Kite";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        republic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Republic";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        valentine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Valentine Special";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });
        holi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, cat.class);
                String morning = "Holi";
                for (int j = 0; j < dataList.size(); j++) {
                    String store = dataList.get(j).cate;
                    if (store.equalsIgnoreCase(morning)) {
                        k++;
                    }
                }
                Toast.makeText(MainActivity.this, "" + k, Toast.LENGTH_SHORT).show();
                a.putExtra("size", k);
                a.putExtra("morning", morning);
                startActivity(a);
            }
        });

    }
}