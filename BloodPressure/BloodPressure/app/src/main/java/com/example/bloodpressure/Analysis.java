package com.example.bloodpressure;

import static com.example.bloodpressure.R.*;
import static com.example.bloodpressure.SplashScreen.str1;
import static com.example.bloodpressure.SplashScreen.str2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.bloodpressure.Utils2.AdEventListener;
import com.example.bloodpressure.Utils2.AdmobAdManager;
import com.facebook.ads.Ad;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.google.android.material.chip.Chip;
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

public class Analysis extends AppCompatActivity {

    PieChart pieChart;
    ArrayList<PieEntry> pieEntries = new ArrayList<>();
    LinearLayout analysis,analysisdata;
    AdapterHistory adapterHistory;
    ImageView back;
    ArrayList<ModalHistory> userList = new ArrayList<>();
    int tnormal;
    int thypertension;
    int televated;
    int thypers1;
    int thypers2;
    int thypercrisis;
    private RelativeLayout adlayout;
    public FrameLayout native_ad_layout;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_analysis);

        TextView mindis = findViewById(id.mindis);
        TextView minsys = findViewById(id.minsys);
        TextView maxdis = findViewById(id.maxdis);
        TextView maxsys = findViewById(id.maxsys);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        native_ad_layout = findViewById(R.id.nativeAd);
        adlayout = findViewById(R.id.adlayout);


        if (str2.equals("")) {
            adlayout.setVisibility(View.GONE);
        } else {
            adlayout.setVisibility(View.VISIBLE);
        }

        pieChart = findViewById(id.idPieChart);
        analysis = findViewById(id.analysis);
        pieEntries = new ArrayList<>();

        SharedPreferences sharedPref = getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPref.getString("courses", null);
        Type type = new TypeToken<ArrayList<ModalHistory>>() {
        }.getType();
        userList = gson.fromJson(json, type);
        if (userList == null) {
            userList = new ArrayList<>();
        }

                List<Integer> systolicValues = new ArrayList<>();
                List<Integer> diastolicValues = new ArrayList<>();

                for (ModalHistory history : userList) {

                    String systolicValue;
                    String diastolicValue;
                    String statusvalue = history.getHstatus();

                    if(history.getHsys() == null)
                    {
                        systolicValue = "100";
                    }
                    else
                    {
                        systolicValue = history.getHsys();
                    }

                    if(history.getHdis() == null)
                    {
                        diastolicValue = "75";
                    }
                    else
                    {
                        diastolicValue = history.getHdis();
                    }

                    // Make sure systolicValue and diastolicValue are not null or empty
                    if (systolicValue != null && !systolicValue.isEmpty()) {
                        systolicValues.add(Integer.parseInt(systolicValue));
                    }
                    if (diastolicValue != null && !diastolicValue.isEmpty()) {
                        diastolicValues.add(Integer.parseInt(diastolicValue));
                    }


                int minSystolic = systolicValues.isEmpty() ? 100 : Collections.min(systolicValues);
                int maxSystolic = systolicValues.isEmpty() ? 40 : Collections.max(systolicValues);
                int minDiastolic = diastolicValues.isEmpty() ? 75 : Collections.min(diastolicValues);
                int maxDiastolic = diastolicValues.isEmpty() ? 40 : Collections.max(diastolicValues);

                Log.d("tag", "minSystolic: " + minSystolic + ", maxSystolic: " + maxSystolic);
                Log.d("tag", "minDiastolic: " + minDiastolic + ", maxDiastolic: " + maxDiastolic);

                minsys.setText(String.valueOf(minSystolic));
                mindis.setText(String.valueOf(minDiastolic));
                maxdis.setText(String.valueOf(maxDiastolic));
                maxsys.setText(String.valueOf(maxSystolic));


                try {
                if (statusvalue == null) {
                    tnormal += 1;
                } else if (statusvalue.equals("◉ Hypotension")) {
                    thypertension += 1;
                } else if (statusvalue.equals("◉ Normal")) {
                    tnormal += 1;
                } else if (statusvalue.equals("◉ Elevated")) {
                    televated += 1;
                } else if (statusvalue.equals("◉ Hypertension Stage 1")) {
                    thypers1 += 1;
                } else if (statusvalue.equals("◉ Hypertension Stage 2")) {
                    thypers2 += 1;
                } else if (statusvalue.equals("◉ Hypertensive Crisis")) {
                    thypercrisis += 1;
                }
                Log.d("Data", "data value: " + tnormal + "/" + thypers1);
            } catch (NumberFormatException e) {
                int systolic = 100;
                int diastolic = 80;
                tnormal += 1;
            }
        }
        pieChart.setDrawEntryLabels(false);
        pieChart.getDescription().setEnabled(false);

//       pieEntries.add(new PieEntry(thypertension, "Hypotension"));
//       pieEntries.add(new PieEntry(tnormal, "Normal"));
//       pieEntries.add(new PieEntry(televated, "Elevated"));
//       pieEntries.add(new PieEntry(thypers1, "Hypertension Stage 1"));
//       pieEntries.add(new PieEntry(thypers2, "Hypertension Stage 2"));
//       pieEntries.add(new PieEntry(thypercrisis, "Hypertensive Crisis"));


        pieEntries.add(new PieEntry(thypertension, ""));
        pieEntries.add(new PieEntry(tnormal, ""));
        pieEntries.add(new PieEntry(televated, ""));
        pieEntries.add(new PieEntry(thypers1, ""));
        pieEntries.add(new PieEntry(thypers2, ""));
        pieEntries.add(new PieEntry(thypercrisis, ""));


        int[] colors = {getColor(color.blue), getColor(color.green), getColor(color.lyellow), getColor(color.yellow), getColor(color.orange), getColor(color.red)};

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColors(colors);

        pieDataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                if (value == 0) {
                    return "";
                } else {
                    return String.valueOf((int) value);
                }

            }
        });
        pieChart.setExtraOffsets(0f, 0f, 0f, 20f);

        pieDataSet.setValueTextSize(14f);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieChart.setEntryLabelColor(Color.BLACK);
        Legend legend = pieChart.getLegend();
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setWordWrapEnabled(true);
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        legend.setTextSize(14f);
        legend.setTextColor(Color.BLACK);
        legend.setFormSize(14f);
        legend.setXEntrySpace(16f);
        legend.setYEntrySpace(5f);
        legend.setFormToTextSpace(5f);
        legend.setMaxSizePercent(0.5f);

        legend.setForm(Legend.LegendForm.NONE);
//        legend.setForm(Legend.LegendForm.CIRCLE);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (str1.equals("g")) {

            refreshAd();


        } else {

            FbNativeAd();



        }
    }



    private void refreshAd() {
        if (AdmobAdManager.getInstance().isAdLoadProcessing) {

            AdmobAdManager.getInstance().adEventListener = new AdEventListener() {
                @Override
                public void onAdLoaded(Object object) {
                    AdmobAdManager.getInstance().populateNativeAdView( Analysis.this, native_ad_layout, (com.google.android.gms.ads.nativead.NativeAd)object);
                    AdmobAdManager.getInstance().LoadNativeAd(Analysis.this, str2);
                    AdmobAdManager.getInstance().adEventListener = null;
                }

                @Override
                public void onAdClosed() {
                }

                @Override
                public void onLoadError(String errorCode) {

                }
            };
        }
        else
        {
            if(AdmobAdManager.getInstance().mNativeAd != null)
            {
                //  Toast.makeText( , "loads2", Toast.LENGTH_SHORT ).show();
                AdmobAdManager.getInstance().populateNativeAdView(Analysis.this, native_ad_layout, AdmobAdManager.getInstance().mNativeAd);
                AdmobAdManager.getInstance().LoadNativeAd(Analysis.this, str2);
            }
        }
    }


    //********************************Facebook native **************************************************************
    private NativeAdLayout nativeAdLayout1,nativeAdLayout2;
    private LinearLayout adView1;
    private com.facebook.ads.NativeAd nativeAd1_,nativeAd2_;

    private void FbNativeAd() {
        AdSettings.addTestDevice(getString(R.string.fb_testing));

        nativeAdLayout1 = findViewById(R.id.native_ad_container);

        // Instantiate a NativeAd object.
        // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
        // now, while you are testing and replace it later when you have signed up.
        // While you are using this temporary code you will only get test ads and if you release
        // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
        nativeAd1_ = new com.facebook.ads.NativeAd(this, str2);
        NativeAdListener nativeAdListener = new NativeAdListener() {

            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, com.facebook.ads.AdError adError) {

               /* nativeAdLayout1.setVisibility(View.GONE);
                refreshAd();*/
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Race condition, load() called again before last ad was displayed
                if (nativeAd1_ == null || nativeAd1_ != ad) {
                    return;
                }
                // Inflate Native Ad into Container
                inflateAd(nativeAd1_);
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }

        };

        // Request an ad
        nativeAd1_.loadAd(
                nativeAd1_.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }


    private void inflateAd(com.facebook.ads.NativeAd nativeAd) {

        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        LayoutInflater inflater = LayoutInflater.from(Analysis.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView1 = (LinearLayout) inflater.inflate(R.layout.fb_native_ad, nativeAdLayout1, false);
        nativeAdLayout1.addView(adView1);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container1);
        AdOptionsView adOptionsView = new AdOptionsView(Analysis.this, nativeAd, nativeAdLayout1);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        com.facebook.ads.MediaView nativeAdIcon = adView1.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = adView1.findViewById(R.id.native_ad_title);
        com.facebook.ads.MediaView nativeAdMedia = adView1.findViewById(R.id.native_ad_media);
        TextView nativeAdSocialContext = adView1.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = adView1.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = adView1.findViewById(R.id.native_ad_sponsored_label);
        Button nativeAdCallToAction = adView1.findViewById(R.id.native_ad_call_to_action);

        // Set the Text.
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        // Create a list of clickable views
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);

        // Register the Title and CTA button to listen for clicks.
        nativeAd.registerViewForInteraction(
                adView1, nativeAdMedia, nativeAdIcon, clickableViews);
    }


    //********************************Facebook native over *******************************************************


}
