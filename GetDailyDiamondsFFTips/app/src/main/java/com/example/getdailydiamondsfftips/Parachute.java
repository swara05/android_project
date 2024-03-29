package com.example.getdailydiamondsfftips;

import static com.example.getdailydiamondsfftips.Splash_screen.str1;
import static com.example.getdailydiamondsfftips.Splash_screen.str2;
import static com.example.getdailydiamondsfftips.Splash_screen.str4;
import static com.example.getdailydiamondsfftips.Utils2.Global.isNetworkAvailable;
import static com.facebook.ads.AudienceNetworkAds.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.getdailydiamondsfftips.Utils2.AdEventListener;
import com.example.getdailydiamondsfftips.Utils2.AdmobAdManager;
import com.facebook.ads.Ad;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.List;

public class Parachute extends AppCompatActivity {

    ImageView backpara,apoc,beach,circus,pan,dragne,drago,hiphop,cobra,panthera,santa,shark,winer;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private boolean key = false;
    private RelativeLayout adlayout, adlayout2;
    public FrameLayout native_ad_layout, native_ad_layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parachute);

        apoc = findViewById(R.id.apoc);
        beach = findViewById(R.id.beach);
        circus = findViewById(R.id.circus);
        pan = findViewById(R.id.pan);
        dragne = findViewById(R.id.dragne);
        drago = findViewById(R.id.drago);
        hiphop = findViewById(R.id.hiphop);
        panthera = findViewById(R.id.panthera);
        santa = findViewById(R.id.santa);
        shark = findViewById(R.id.shark);
        cobra = findViewById(R.id.cobra);
        winer = findViewById(R.id.winer);
        backpara = findViewById(R.id.backpara);

        native_ad_layout = findViewById(R.id.nativeAd);
        native_ad_layout2 = findViewById(R.id.nativeAd2);

        adlayout = findViewById(R.id.adlayout);
        adlayout2 = findViewById(R.id.adlayout2);


        if (str2.equals("")) {
            adlayout.setVisibility(View.GONE);
            adlayout2.setVisibility(View.GONE);

        } else {
            adlayout.setVisibility(View.VISIBLE);
            adlayout2.setVisibility(View.VISIBLE);

        }



        backpara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        apoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Apocalypse Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Apocalypse Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Apocalypse Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Apocalypse Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Apocalypse Parachute");
                            startActivity(pa);

                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Apocalypse Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Apocalypse Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Apocalypse Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Apocalypse Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });

        beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Beach Party Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Beach Party Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Beach Party Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Beach Party Parachute");
                                startActivity(pa);
                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Beach Party Parachute");
                            startActivity(pa);
                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Beach Party Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Beach Party Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Beach Party Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Beach Party Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
        circus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Circus Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Circus Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Circus Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Circus Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Circus Parachute");
                            startActivity(pa);

                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Circus Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Circus Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Circus Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Circus Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
        pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Panda Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Panda Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Panda Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Panda Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Panda Parachute");
                            startActivity(pa);

                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Panda Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Panda Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Panda Parachute");
                                startActivity(pa);
                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Panda Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
        dragne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Dragne Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Dragne Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Dragne Parachute");
                                                startActivity(pa);
                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Dragne Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Dragne Parachute");
                            startActivity(pa);

                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Dragne Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Dragne Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Dragne Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Dragne Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
        drago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Dragon Slayor Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Dragon Slayor Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Dragon Slayor Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Dragon Slayor Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Dragon Slayor Parachute");
                            startActivity(pa);

                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Dragon Slayor Parachute");
                                        startActivity(pa);
                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Dragon Slayor Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Dragon Slayor Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Dragon Slayor Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
        hiphop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Hip Hop Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Hip Hop Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Hip Hop Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Hip Hop Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Hip Hop Parachute");
                            startActivity(pa);

                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Hip Hop Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Hip Hop Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Hip Hop Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Hip Hop Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
        cobra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Cobra Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Cobra Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Cobra Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Cobra Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Cobra Parachute");
                            startActivity(pa);

                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Cobra Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Cobra Parachute");
                                        startActivity(pa);
                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Cobra Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Cobra Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
        panthera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Panthera Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Panthera Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Panthera Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Panthera Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Panthera Parachute");
                            startActivity(pa);
                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Panthera Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Panthera Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Panthera Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Panthera Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
        santa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Santa Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Santa Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Santa Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Santa Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Santa Parachute");
                            startActivity(pa);

                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Santa Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Santa Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Santa Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Santa Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
        shark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Shark Attech Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Shark Attech Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Shark Attech Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Shark Attech Parachute");
                                startActivity(pa);
                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Shark Attech Parachute");
                            startActivity(pa);

                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Shark Attech Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Shark Attech Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Shark Attech Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Shark Attech Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
        winer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(Parachute.this, Parachute.this.getString(R.string.app_name),
                                        Parachute.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(Parachute.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(Parachute.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Winerlands Parachute");
                                                                startActivity(pa);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                                pa.putExtra("parachute","Winerlands Parachute");
                                                                startActivity(pa);

                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdShowedFullScreenContent() {
                                                                // Called when fullscreen content is shown.
                                                                Log.d("TAG", "The ad was shown.");

                                                                progress.dismiss();
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                // Handle the error
                                                progress.dismiss();

                                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                                pa.putExtra("parachute","Winerlands Parachute");
                                                startActivity(pa);

                                                key = false;


                                            }
                                        });
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Winerlands Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Winerlands Parachute");
                            startActivity(pa);

                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(Parachute.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(Parachute.this, str4);
                                // Create listeners for the Interstitial Ad
                                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                    @Override
                                    public void onInterstitialDisplayed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad displayed callback
                                        Log.e(TAG, "Interstitial ad displayed.");
                                    }

                                    @Override
                                    public void onInterstitialDismissed(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial dismissed callback
                                        Log.e(TAG, "Interstitial ad dismissed.");

                                        //1
                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Winerlands Parachute");
                                        startActivity(pa);

                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                        pa.putExtra("parachute","Winerlands Parachute");
                                        startActivity(pa);

                                        key = false;


                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        progress.dismiss();
                                        // Interstitial ad is loaded and ready to be displayed
                                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                                        // Show the ad
                                        interstitialAd.show();
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {
                                        // Ad clicked callback
                                        Log.d(TAG, "Interstitial ad clicked!");
                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {
                                        // Ad impression logged callback
                                        Log.d(TAG, "Interstitial ad impression logged!");
                                    }
                                };

                                // For auto play video ads, it's recommended to load the ad
                                // at least 30 seconds before it is shown
                                interstitialAd.loadAd(
                                        interstitialAd.buildLoadAdConfig()
                                                .withAdListener(interstitialAdListener)
                                                .build());

                                //************************************* Fb NEW  Over ..........................
                            } else {
                                Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                                pa.putExtra("parachute","Winerlands Parachute");
                                startActivity(pa);

                                key = false;

                            }

                        } else {
                            Intent pa = new Intent(Parachute.this,ParachuteDiamond.class);
                            pa.putExtra("parachute","Winerlands Parachute");
                            startActivity(pa);
                            key = false;

                        }

                    }
                }

            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        if (str1.equals("g")) {

            refreshAd();
            refreshAd2();



        } else {

            FbNativeAd();
            FbNativeAd2();



        }
    }



    private void refreshAd2() {

        if (AdmobAdManager.getInstance().isAdLoadProcessing3) {

            AdmobAdManager.getInstance().adEventListener = new AdEventListener() {
                @Override
                public void onAdLoaded(Object object) {
                    AdmobAdManager.getInstance().populateNativeAdView3( Parachute.this, native_ad_layout2, (com.google.android.gms.ads.nativead.NativeAd)object);
                    AdmobAdManager.getInstance().LoadNativeAd3(Parachute.this, str2);
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
            if(AdmobAdManager.getInstance().mNativeAd3 != null)
            {
                //  Toast.makeText( , "loads2", Toast.LENGTH_SHORT ).show();
                AdmobAdManager.getInstance().populateNativeAdView3(Parachute.this, native_ad_layout2, AdmobAdManager.getInstance().mNativeAd3);
                AdmobAdManager.getInstance().LoadNativeAd3(Parachute.this, str2);
            }
        }
    }

    private void refreshAd() {
        if (AdmobAdManager.getInstance().isAdLoadProcessing) {

            AdmobAdManager.getInstance().adEventListener = new AdEventListener() {
                @Override
                public void onAdLoaded(Object object) {
                    AdmobAdManager.getInstance().populateNativeAdView( Parachute.this, native_ad_layout, (com.google.android.gms.ads.nativead.NativeAd)object);
                    AdmobAdManager.getInstance().LoadNativeAd(Parachute.this, str2);
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
                AdmobAdManager.getInstance().populateNativeAdView(Parachute.this, native_ad_layout, AdmobAdManager.getInstance().mNativeAd);
                AdmobAdManager.getInstance().LoadNativeAd(Parachute.this, str2);
            }
        }
    }


    //********************************Facebook native **************************************************************
    private NativeAdLayout nativeAdLayout1,nativeAdLayout2,nativeAdLayout3;
    private LinearLayout adView1;
    private com.facebook.ads.NativeAd nativeAd1_,nativeAd2_,nativeAd3_;

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

    private void FbNativeAd2() {
        AdSettings.addTestDevice(getString(R.string.fb_testing));

        nativeAdLayout2 = findViewById(R.id.native_ad_container2);

        // Instantiate a NativeAd object.
        // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
        // now, while you are testing and replace it later when you have signed up.
        // While you are using this temporary code you will only get test ads and if you release
        // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
        nativeAd2_ = new com.facebook.ads.NativeAd(this, str2);
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
                if (nativeAd2_ == null || nativeAd2_ != ad) {
                    return;
                }
                // Inflate Native Ad into Container
                inflateAd(nativeAd2_);
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }

        };

        // Request an ad
        nativeAd2_.loadAd(
                nativeAd2_.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }

    private void inflateAd(com.facebook.ads.NativeAd nativeAd) {

        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        LayoutInflater inflater = LayoutInflater.from(Parachute.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView1 = (LinearLayout) inflater.inflate(R.layout.fb_native_ad, nativeAdLayout1, false);
        nativeAdLayout1.addView(adView1);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container1);
        AdOptionsView adOptionsView = new AdOptionsView(Parachute.this, nativeAd, nativeAdLayout1);
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