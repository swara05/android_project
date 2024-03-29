package com.example.admob;

import static com.example.admob.Utils2.Global.isNetworkAvailable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.admob.Api.RestAdsApi;
import com.example.admob.Pojo.Counter.Counter;
import com.example.admob.Pojo.Data;
import com.example.admob.Pojo.Devtesting;
import com.example.admob.Utils2.AdmobAdManager;
import com.example.admob.Utils2.Global;
import com.example.admob.Utils2.GlobalRetro;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class Splash_screen extends AppCompatActivity {

    public static String str1, str2, str3, str4, str5, str6, str7, str8, str_rating, str_status,
            str2_2, str2_3, str7_2, str7_3, str_extra;
    private String pckgname;
    public static String data;
    public static  String AD_UNIT_ID;
    int SPLASH_TIME = 1000;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;
    FullScreenContentCallback fullScreenContentCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (isNetworkAvailable()) {
            pckgname = getApplicationContext().getPackageName();
            getAds();
        }
        else {
            str1 = " ";
            str2 = " ";
            str3 = " ";
            str4 = " ";
            str5 = " ";
            str6 = " ";
            str7 = " ";
            str8 = " ";
            str_rating = " ";
            str_status = " ";
            str2_2 = " ";
            str7_2 = " ";
            str7_3 = " ";
            str_extra = " ";

            new Handler().postDelayed(new Runnable() {
                public void run() {

                        Intent intent = new Intent(Splash_screen.this, Welcome.class);
                        startActivity(intent);
                        finish();

                }
            }, 1000);
        }
        if (!checkNewInstall()) {
            new UpdateDownloadCounter().execute();
        }
    }
    // Ads
    ArrayList<Data> dataArrayList = new ArrayList<>();
    private void getAds() {
        RestAdsApi restApi = GlobalRetro.initRetrofit1(Splash_screen.this);
        // Call<Devtesting> categoryListCall = restApi.DO_URL_DATA("42","508146");
        Call<Devtesting> categoryListCall = restApi.DO_URL_DATA("199");
        categoryListCall.enqueue(new Callback<Devtesting>() {
            @SuppressLint("MissingPermission")
            @Override
            public void onResponse(Call<Devtesting> call, retrofit2.Response<Devtesting> response) {
                Log.d("my", response.body() + "");
                if (response.body() != null) {


                    if (response.body().getStatus().equals("success")) {

                        dataArrayList.add(response.body().getData());
                        str1 = dataArrayList.get(0).getFb_banner();


                        str3 = dataArrayList.get(0).getGoogle_banner();
                        str4 = dataArrayList.get(0).getGoogle_interstitial();
                        str5 = dataArrayList.get(0).getGoogle_native();

                        str7 = dataArrayList.get(0).getFb_native();
                        str2_2 = dataArrayList.get(0).getFb_interstitial_two();
                        str2 = dataArrayList.get(0).getFb_interstitial();


                        str6 = dataArrayList.get(0).getStartapp_id();
                        Log.d("str6", str6 + "");

                        AD_UNIT_ID = str6;
                        Global.set_email_add(str6);



                        if(dataArrayList.get(0).getFb_banner().isEmpty())
                        {
                            str1 = "g";
                        }
                        else
                        {
                            str1 = dataArrayList.get(0).getFb_banner();
                        }

                        Log.d("mY",str1);
                        str8 = dataArrayList.get(0).getStartapp_source(); //FB Native Banner
                        str_rating = dataArrayList.get(0).getRating(); //Rating Status (Bydefault No)

                        str2_3 = dataArrayList.get(0).getFb_interstitial_three();
                        str7_2 = dataArrayList.get(0).getFb_native_two();
                        str7_3 = dataArrayList.get(0).getFb_native_three();
                        str_extra = dataArrayList.get(0).getVisible_extra();
                        str_status = dataArrayList.get(0).getApp_status();

                        AdmobAdManager.getInstance().LoadNativeAd(Splash_screen.this, str2);


                        if(!str6.isEmpty())
                        {
                            callopenads();
                            InitAppOpenAd();
                        }
                        else
                        {
                            new Handler().postDelayed( new Runnable() {
                                public void run() {

                                        Intent intent = new Intent(Splash_screen.this, Welcome.class);
                                        startActivity(intent);
                                        finish();

                                }
                            }, 1000);

                        }
                    }

                } else {

                }
            }


            @Override
            public void onFailure(Call<Devtesting> call, Throwable t) {
                Log.d("Piyush", t + "");

                GlobalRetro.showToast(Splash_screen.this, "Something went to wrong");
            }
        });
    }

    private void callopenads() {
        data = "0";
    }

// Ads Over

    private void InitAppOpenAd() {
        fullScreenContentCallback = new FullScreenContentCallback() {
            @Override
            public void onAdDismissedFullScreenContent() {
                // Set the reference to null so isAdAvailable() returns false.
                Log.d("TAG", "onAdDismissedFullScreenContent: ");
                //Call next Activity

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(Splash_screen.this, Welcome.class);
                        startActivity(intent);
                        finish();

                    }
                }, (long) SPLASH_TIME);
            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                Log.d("TAG", "onAdFailedToShowFullScreenContent: ");
                //Call next Activity

                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        Intent intent = new Intent(Splash_screen.this, Welcome.class);
                        startActivity(intent);
                        finish();
                    }
                }, (long) SPLASH_TIME);
            }

            @Override
            public void onAdShowedFullScreenContent() {

            }
        };
        loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                super.onAdLoaded(appOpenAd);

                appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                appOpenAd.show(Splash_screen.this);
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.d("TAG", "onAdFailedToLoad: " + loadAdError.getMessage());
                //Call next Activity

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(Splash_screen.this, Welcome.class);
                        startActivity(intent);
                        finish();
                    }
                }, (long) SPLASH_TIME);
            }
        };
        AdRequest request = getAdRequest();
        AppOpenAd.load(Splash_screen.this, str6, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
    }
    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }


    //***************************************************************App Counter

    private static String INSTALL_PREF = "install_pref_infius";

    private boolean checkNewInstall() {
        // TODO Auto-generated method stub
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                this.getPackageName(), Context.MODE_PRIVATE);

        boolean install_pref = sharedPreferences
                .getBoolean(INSTALL_PREF, false);

        if (!install_pref) {
            sharedPreferences.edit().putBoolean(INSTALL_PREF, true).commit();
        }

        return install_pref;
    }

    private class UpdateDownloadCounter extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... input) {
            updateDownloadCounter();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }

    /*
            r19 = this;
            r0 = r19
            super.onCreate(r20)
            java.lang.String r1 = "speedometer_preferences"
            r2 = 0
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r2)
            r0.preferences = r1
            java.lang.String r3 = "darkMode"
            r4 = 1
            boolean r1 = r1.getBoolean(r3, r4)
            r0.dark_mode = r1
            java.lang.String r3 = "burgundy"
            java.lang.String r5 = "displayColor"
            java.lang.String r6 = "bgColor"
            java.lang.String r7 = "black"
            java.lang.String r8 = "skin"
            java.lang.String r9 = "red"
            if (r1 == 0) goto L_0x0036
            android.content.SharedPreferences r1 = r0.preferences
            java.lang.String r1 = r1.getString(r6, r7)
            r0.bgColor = r1
            android.content.SharedPreferences r1 = r0.preferences
            java.lang.String r1 = r1.getString(r5, r9)
            r0.displayColor = r1
            goto L_0x0046
        L_0x0036:
            android.content.SharedPreferences r1 = r0.preferences
            java.lang.String r1 = r1.getString(r6, r8)
            r0.bgColor = r1
            android.content.SharedPreferences r1 = r0.preferences
            java.lang.String r1 = r1.getString(r5, r3)
            r0.displayColor = r1
        L_0x0046:
            java.lang.String r1 = r0.bgColor
            java.lang.String r5 = "lime"
            java.lang.String r6 = "cyan"
            java.lang.String r11 = "green"
            r16 = 2
            java.lang.String r10 = "blue"
            java.lang.String r12 = "purple"
            r17 = -1
            if (r1 == 0) goto L_0x00e6
            r1.hashCode()
            int r18 = r1.hashCode()
            switch(r18) {
                case -976943172: goto L_0x00a3;
                case 112785: goto L_0x009a;
                case 3027034: goto L_0x0091;
                case 3068707: goto L_0x0088;
                case 3321813: goto L_0x007f;
                case 3532157: goto L_0x0076;
                case 93818879: goto L_0x006d;
                case 98619139: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            r1 = -1
            goto L_0x00ab
        L_0x0064:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x006b
            goto L_0x0062
        L_0x006b:
            r1 = 7
            goto L_0x00ab
        L_0x006d:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0074
            goto L_0x0062
        L_0x0074:
            r1 = 6
            goto L_0x00ab
        L_0x0076:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x007d
            goto L_0x0062
        L_0x007d:
            r1 = 5
            goto L_0x00ab
        L_0x007f:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0086
            goto L_0x0062
        L_0x0086:
            r1 = 4
            goto L_0x00ab
        L_0x0088:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x008f
            goto L_0x0062
        L_0x008f:
            r1 = 3
            goto L_0x00ab
        L_0x0091:
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x0098
            goto L_0x0062
        L_0x0098:
            r1 = 2
            goto L_0x00ab
        L_0x009a:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x00a1
            goto L_0x0062
        L_0x00a1:
            r1 = 1
            goto L_0x00ab
        L_0x00a3:
            boolean r1 = r1.equals(r12)
            if (r1 != 0) goto L_0x00aa
            goto L_0x0062
        L_0x00aa:
            r1 = 0
        L_0x00ab:
            switch(r1) {
                case 0: goto L_0x00e0;
                case 1: goto L_0x00d9;
                case 2: goto L_0x00d2;
                case 3: goto L_0x00cb;
                case 4: goto L_0x00c4;
                case 5: goto L_0x00bd;
                case 6: goto L_0x00b6;
                case 7: goto L_0x00af;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            goto L_0x00e6
        L_0x00af:
            r1 = 2132017164(0x7f14000c, float:1.9672599E38)
            r0.setTheme(r1)
            goto L_0x00e6
        L_0x00b6:
            r1 = 2132017166(0x7f14000e, float:1.9672603E38)
            r0.setTheme(r1)
            goto L_0x00e6
        L_0x00bd:
            r1 = 2132017489(0x7f140151, float:1.9673258E38)
            r0.setTheme(r1)
            goto L_0x00e6
        L_0x00c4:
            r1 = 2132017407(0x7f1400ff, float:1.9673092E38)
            r0.setTheme(r1)
            goto L_0x00e6
        L_0x00cb:
            r1 = 2132017398(0x7f1400f6, float:1.9673073E38)
            r0.setTheme(r1)
            goto L_0x00e6
        L_0x00d2:
            r1 = 2132017163(0x7f14000b, float:1.9672597E38)
            r0.setTheme(r1)
            goto L_0x00e6
        L_0x00d9:
            r1 = 2132017165(0x7f14000d, float:1.96726E38)
            r0.setTheme(r1)
            goto L_0x00e6
        L_0x00e0:
            r1 = 2132017442(0x7f140122, float:1.9673163E38)
            r0.setTheme(r1)
        L_0x00e6:
            r1 = 2131558501(0x7f0d0065, float:1.874232E38)
            r0.setContentView((int) r1)
            r1 = 2131362197(0x7f0a0195, float:1.8344168E38)
            android.view.View r1 = r0.findViewById(r1)
            com.google.android.material.bottomnavigation.BottomNavigationView r1 = (com.google.android.material.bottomnavigation.BottomNavigationView) r1
            r0.navView = r1
            r1 = 2131362193(0x7f0a0191, float:1.834416E38)
            android.view.View r1 = r0.findViewById(r1)
            com.google.android.material.navigation.NavigationView r1 = (com.google.android.material.navigation.NavigationView) r1
            r0.navigationView = r1
            r1 = 2131361889(0x7f0a0061, float:1.8343543E38)
            android.view.View r1 = r0.findViewById(r1)
            androidx.drawerlayout.widget.DrawerLayout r1 = (androidx.drawerlayout.widget.DrawerLayout) r1
            r0.drawerLayout = r1
            r1 = 2131362091(0x7f0a012b, float:1.8343953E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.indicator = r1
            r1 = 2131361915(0x7f0a007b, float:1.8343596E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.analog = r1
            r1 = 2131362012(0x7f0a00dc, float:1.8343793E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.digital = r1
            r1 = 2131362117(0x7f0a0145, float:1.8344006E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.map = r1
            androidx.appcompat.app.ActionBarDrawerToggle r1 = new androidx.appcompat.app.ActionBarDrawerToggle
            androidx.drawerlayout.widget.DrawerLayout r13 = r0.drawerLayout
            r14 = 2131951798(0x7f1300b6, float:1.954002E38)
            r15 = 2131951668(0x7f130034, float:1.9539757E38)
            r1.<init>(r0, r13, r14, r15)
            r0.drawerToggle = r1
            androidx.drawerlayout.widget.DrawerLayout r13 = r0.drawerLayout
            r13.addDrawerListener(r1)
            androidx.appcompat.app.ActionBarDrawerToggle r1 = r0.drawerToggle
            r1.syncState()
            r1 = 2131362195(0x7f0a0193, float:1.8344164E38)
            androidx.navigation.NavController r1 = androidx.navigation.Navigation.findNavController(r0, r1)
            com.google.android.material.bottomnavigation.BottomNavigationView r13 = r0.navView
            androidx.navigation.p005ui.NavigationUI.setupWithNavController((com.google.android.material.bottomnavigation.BottomNavigationView) r13, (androidx.navigation.NavController) r1)
            android.content.SharedPreferences r1 = r0.preferences
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.lang.String r13 = "RouteStarted"
            android.content.SharedPreferences$Editor r1 = r1.putBoolean(r13, r2)
            r1.apply()
            java.lang.String r1 = r0.displayColor
            if (r1 == 0) goto L_0x0261
            r1.hashCode()
            int r13 = r1.hashCode()
            switch(r13) {
                case -1177090378: goto L_0x01cf;
                case -976943172: goto L_0x01c6;
                case -734239628: goto L_0x01bb;
                case -338689002: goto L_0x01b0;
                case 112785: goto L_0x01a7;
                case 3002044: goto L_0x019c;
                case 3027034: goto L_0x0193;
                case 94011702: goto L_0x0188;
                case 98619139: goto L_0x017e;
                default: goto L_0x017b;
            }
        L_0x017b:
            r1 = -1
            goto L_0x01d7
        L_0x017e:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x0185
            goto L_0x017b
        L_0x0185:
            r1 = 8
            goto L_0x01d7
        L_0x0188:
            java.lang.String r3 = "brown"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0191
            goto L_0x017b
        L_0x0191:
            r1 = 7
            goto L_0x01d7
        L_0x0193:
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x019a
            goto L_0x017b
        L_0x019a:
            r1 = 6
            goto L_0x01d7
        L_0x019c:
            java.lang.String r3 = "aqua"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x01a5
            goto L_0x017b
        L_0x01a5:
            r1 = 5
            goto L_0x01d7
        L_0x01a7:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x01ae
            goto L_0x017b
        L_0x01ae:
            r1 = 4
            goto L_0x01d7
        L_0x01b0:
            java.lang.String r3 = "green_blue"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x01b9
            goto L_0x017b
        L_0x01b9:
            r1 = 3
            goto L_0x01d7
        L_0x01bb:
            java.lang.String r3 = "yellow"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x01c4
            goto L_0x017b
        L_0x01c4:
            r1 = 2
            goto L_0x01d7
        L_0x01c6:
            boolean r1 = r1.equals(r12)
            if (r1 != 0) goto L_0x01cd
            goto L_0x017b
        L_0x01cd:
            r1 = 1
            goto L_0x01d7
        L_0x01cf:
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x01d6
            goto L_0x017b
        L_0x01d6:
            r1 = 0
        L_0x01d7:
            switch(r1) {
                case 0: goto L_0x0258;
                case 1: goto L_0x0240;
                case 2: goto L_0x0236;
                case 3: goto L_0x022c;
                case 4: goto L_0x0222;
                case 5: goto L_0x0218;
                case 6: goto L_0x0200;
                case 7: goto L_0x01f6;
                case 8: goto L_0x01dc;
                default: goto L_0x01da;
            }*/



    private void updateDownloadCounter() {
        RestAdsApi restApi = GlobalRetro.initRetrofit1(Splash_screen.this);
        Call<Counter> categoryListCall = restApi.doCounter_URL_Data("42");
        categoryListCall.enqueue(new Callback<Counter>() {
            @Override
            public void onResponse(Call<Counter> call, retrofit2.Response<Counter> response) {
                Log.d("my_count", response.body() + "");
                if (response.body() != null) {


                    if (response.body().getData().getStatus().equals("success")) {
                        Log.d("Piyush", response.body().getData().getStatus());
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<Counter> call, Throwable t) {

                GlobalRetro.showToast(Splash_screen.this, "Something went to wrong");
            }
        });
    }
}