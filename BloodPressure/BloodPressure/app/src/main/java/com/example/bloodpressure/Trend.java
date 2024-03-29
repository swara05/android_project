package com.example.bloodpressure;


import static com.example.bloodpressure.SplashScreen.str1;
import static com.example.bloodpressure.SplashScreen.str3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import android.graphics.Color;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.facebook.ads.AudienceNetworkAds;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Trend extends AppCompatActivity {


    BarChart barChart;
    ImageView back;
    BarDataSet barDataSet1, barDataSet2;
    ArrayList barEntries;
    ArrayList data;
    TextView hdate, htime, hstatus, hsys, hdis, hpls;
    CardView card;
    private Entry selectedEntry;
    private ArrayList<ModalHistory> historyList;

    LinearLayout gBannerAds, banner_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend);

        back = findViewById(R.id.back);
        hdate = findViewById(R.id.hdate);
        htime = findViewById(R.id.htime);
        hstatus = findViewById(R.id.hstatus);
        hsys = findViewById(R.id.hsys);
        hdis = findViewById(R.id.hdis);
        hpls = findViewById(R.id.hpls);
        card = findViewById(R.id.card);
        // loadData();

        gBannerAds = findViewById(R.id.gBannerAds);
        banner_container = findViewById(R.id.banner_container);

        if (str1.equals("g") )
        {

            New_Google_Banner();
        }
        else
        {
            New_FB_Banner();
        }

        barChart = findViewById(R.id.idBarChart);
        barChart.setExtraOffsets(0f, 0f, 0f, 20f);
        barDataSet1 = new BarDataSet(getBarEntriesOne(), "Systolic");
        barDataSet1.setColor(getApplicationContext().getResources().getColor(R.color.purple_200));
        barDataSet2 = new BarDataSet(getBarEntriesTwo(), "Diastolic");
        barDataSet2.setColor(Color.BLUE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        BarData data = new BarData(barDataSet1, barDataSet2);

        barChart.setData(data);
        barChart.getDescription().setEnabled(false);
        barChart.setDragEnabled(true);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setCenterAxisLabels(true);
        YAxis rightYAxis = barChart.getAxisRight();
        rightYAxis.setEnabled(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setGranularity(1);
//   xAxis.setGranularityEnabled(true);
        barChart.setVisibleXRangeMaximum(3);
        barChart.setDrawGridBackground(false);
        float barSpace = 0.1f;
        float groupSpace = 0.5f;
        data.setBarWidth(0.14f);
        barChart.getXAxis().setAxisMinimum(0);
        //barChart.animate();
        barChart.groupBars(0, groupSpace, barSpace);
        barChart.invalidate();
        // xAxis.setLabelRotationAngle(45);
        barChart.setFitBars(true);

        SharedPreferences sharedPref = getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPref.getString("courses", null);
        Type type = new TypeToken<ArrayList<ModalHistory>>() {
        }.getType();
        historyList = gson.fromJson(json, type);
        if (historyList == null) {
            historyList = new ArrayList<>();
        }
        card.setVisibility(View.GONE);

        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                selectedEntry = e;
                int index = (int) e.getX();
                card.setVisibility(View.VISIBLE);
                ModalHistory selectedHistory = historyList.get(index);
                String date = selectedHistory.getHdate();
                String time = selectedHistory.getHtime();
                String status;
                String syst;
                String dist;
                String plst;

                if (selectedHistory.getHsys() == null) {
                    syst = "100";
                } else {
                    syst = selectedHistory.getHsys();
                }

                if (selectedHistory.getHdis() == null) {
                    dist = "75";
                } else {
                    dist = selectedHistory.getHdis();
                }

                if (selectedHistory.getHpls() == null) {
                    plst = "70";
                } else {
                    plst = selectedHistory.getHpls();
                }

                if (selectedHistory.getHstatus() == null) {
                    status = "◉ Normal";
                } else {
                    status = selectedHistory.getHstatus();
                }

                if (selectedHistory.getHstatus() == null) {
                    hstatus.setTextColor(ContextCompat.getColor(Trend.this, R.color.green));
                } else if (selectedHistory.getHstatus().equals("◉ Hypotension")) {
                    hstatus.setTextColor(ContextCompat.getColor(Trend.this, R.color.blue));
                } else if (selectedHistory.getHstatus().equals("◉ Normal")) {
                    hstatus.setTextColor(ContextCompat.getColor(Trend.this, R.color.green));
                } else if (selectedHistory.getHstatus().equals("◉ Elevated")) {
                    hstatus.setTextColor(ContextCompat.getColor(Trend.this, R.color.light_yello));
                } else if (selectedHistory.getHstatus().equals("◉ Hypertension Stage 1")) {
                    hstatus.setTextColor(ContextCompat.getColor(Trend.this, R.color.yellow));
                } else if (selectedHistory.getHstatus().equals("◉ Hypertension Stage 2")) {
                    hstatus.setTextColor(ContextCompat.getColor(Trend.this, R.color.orange));
                } else if (selectedHistory.getHstatus().equals("◉ Hypertensive Crisis")) {
                    hstatus.setTextColor(ContextCompat.getColor(Trend.this, R.color.red));
                } else {
                    hstatus.setTextColor(ContextCompat.getColor(Trend.this, R.color.green));
                }

                hdate.setText(date);
                htime.setText(time);
                hstatus.setText(status);
                hsys.setText(syst);
                hdis.setText(dist);
                hpls.setText(plst);
            }


            @Override
            public void onNothingSelected() {
                card.setVisibility(View.GONE);
            }

        });
    }


    private ArrayList<BarEntry> getBarEntriesOne() {

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        SharedPreferences sharedPref = getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPref.getString("courses", null);
        Type type = new TypeToken<ArrayList<ModalHistory>>() {
        }.getType();
        ArrayList<ModalHistory> userList = gson.fromJson(json, type);
        if (userList == null) {
            userList = new ArrayList<>();
        }

        int counter = 0;
        for (ModalHistory history : userList) {
            String systolicValue = history.getHsys();
            String date = history.getHdate();
            String time = history.getHtime();
            String status = history.getHstatus();


            try {
                int systolic = Integer.parseInt(systolicValue);
                barEntries.add(new BarEntry(counter, systolic));
                XAxis xAxis = barChart.getXAxis();
                data.add(counter, date + "\n" + time);
                xAxis.setValueFormatter(new IndexAxisValueFormatter(data));
                Log.d("Data", "data value: " + systolicValue);


            } catch (NumberFormatException e) {
                int systolic = 100;
                barEntries.add(new BarEntry(counter, systolic));
                XAxis xAxis = barChart.getXAxis();
                data.add(counter, date + "\n" + time);
                xAxis.setValueFormatter(new IndexAxisValueFormatter(data));
                Log.e("Data", e.getMessage(), e);
            }

            counter++;
        }

        return barEntries;
    }


    private ArrayList<BarEntry> getBarEntriesTwo() {

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        SharedPreferences sharedPref = getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPref.getString("courses", null);
        Type type = new TypeToken<ArrayList<ModalHistory>>() {
        }.getType();
        ArrayList<ModalHistory> userList = gson.fromJson(json, type);
        if (userList == null) {
            userList = new ArrayList<>();
        }
        int counter = 0;
        for (ModalHistory history : userList) {

            String diastolicValue = history.getHdis();
            String date = history.getHdate();
            String time = history.getHtime();

            try {
                int diastolic = Integer.parseInt(diastolicValue);
                barEntries.add(new BarEntry(counter, diastolic));
                XAxis xAxis = barChart.getXAxis();
                data.add(counter, date + "\n" + time);
                xAxis.setValueFormatter(new IndexAxisValueFormatter(data));
                Log.d("Data", "data value: " + diastolicValue);
            } catch (NumberFormatException e) {
                int systolic = 100;
                int diastolic = 75;
                barEntries.add(new BarEntry(counter, diastolic));
                XAxis xAxis = barChart.getXAxis();
                data.add(counter, date + "\n" + time);
                xAxis.setValueFormatter(new IndexAxisValueFormatter(data));
                Log.e("Data", "Failed to parse value: " + e.getMessage());
            }
            counter++;
        }
        return barEntries;
    }

    private AdView adView;

    public void New_Google_Banner() {

        gBannerAds = findViewById(R.id.gBannerAds);

        adView = new AdView(this);
        adView.setAdUnitId(str3);
        gBannerAds.addView(adView);
        loadBanner();
    }

    private void loadBanner() {
        // Create an ad request. Check your logcat output for the hashed device ID
        // to get test ads on a physical device, e.g.,
        // "Use AdRequest.Builder.addTestDevice("ABCDE0123") to get test ads on this
        // device."
        AdRequest adRequest = new AdRequest.Builder().build();
        AdSize adSize = getAdSize();
        // Step 4 - Set the adaptive ad size on the ad view.
        adView.setAdSize(adSize);


        // Step 5 - Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }


    //**********************************facebook banner  ************************************************************
    private com.facebook.ads.AdView adView2;

    private void New_FB_Banner() {

        AudienceNetworkAds.initialize(this);
        adView2 = new com.facebook.ads.AdView(this, str3, com.facebook.ads.AdSize.BANNER_HEIGHT_50);

// Find the Ad Container


// Add the ad view to your activity layout
        banner_container.addView(adView2);

// Request an ad
        adView2.loadAd();


    }
}

        //**********************************facebook banner over ********************************************************

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        SharedPreferences sharedPref = getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sharedPref.getString("courses", null);
//        Type type = new TypeToken<ArrayList<ModalHistory>>() {}.getType();
//        ArrayList<ModalHistory> userList = gson.fromJson(json, type);
//        if (userList == null) {
//            userList = new ArrayList<>();
//        }
//
//        ArrayList<Entry> entries = new ArrayList<>();
//        ArrayList<Integer> colors = new ArrayList<>(); // to store colors for each data point
//        for (ModalHistory history : userList) {
//            String systolicValue = history.getHsys();
//            String diastolicValue = history.getHdis();
//
//            try {
//                int systolic = Integer.parseInt(systolicValue);
//                int diastolic = Integer.parseInt(diastolicValue);
//                entries.add(new Entry(systolic, diastolic));
//
//                // set color based on category
//                String category = history.getHstatus();
//                int color = Color.GREEN; // default color
//                switch(category) {
//                    case "◉ Normal":
//                        color = Color.GREEN;
//                        break;
//                    case "◉ Hypotension":
//                        color = Color.BLUE;
//                        break;
//                    case "◉ Elevated":
//                        color = Color.parseColor("#DDD05C");
//                        break;
//                    case "◉ Hypertension Stage 1":
//                        color = Color.parseColor("#FBCA36");
//                        break;
//                    case "◉ Hypertension Stage 2":
//                        color = Color.parseColor("#FD8923");
//                        break;
//                    case "◉ Hypertensive Crisis":
//                        color = Color.RED;
//                        break;
//                    default:
//                        color = Color.GREEN;
//                }
//                colors.add(color); // add color to the list
//                Log.d("Data", "data value: " + systolicValue);
//            } catch (NumberFormatException e) {
//                // Handle the error here, e.g. log an error message or skip the entry.
//                int systolic = 100;
//                int diastolic = 75;
//                entries.add(new Entry(systolic, diastolic));
//                int color = Color.GREEN; // default color
//                colors.add(color); // add color to the list
//                Log.e("Data", "Failed to parse value: " + e.getMessage());
//            }
//        }
//
//        ScatterDataSet dataSet = new ScatterDataSet(entries, "Condition");
//        dataSet.setColors(colors); // set the colors of the data points
//        ScatterData scatterData = new ScatterData(dataSet);
//        ScatterChart chart = findViewById(R.id.chart);
//        chart.setData(scatterData);
//
//        chart.getXAxis().setLabelCount(5);
//        chart.getAxisLeft().setLabelCount(5);
//        chart.getAxisRight().setEnabled(false);
//        chart.getDescription().setEnabled(false);
//        chart.setDrawGridBackground(false);
//        chart.setTouchEnabled(true);
//        chart.setDragEnabled(true);
//        chart.setScaleEnabled(true);
//        chart.setPinchZoom(true);

