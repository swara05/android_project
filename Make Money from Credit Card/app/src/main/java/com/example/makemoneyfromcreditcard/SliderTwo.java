package com.example.makemoneyfromcreditcard;


import static com.example.makemoneyfromcreditcard.Splash_screen.str1;
import static com.example.makemoneyfromcreditcard.Splash_screen.str2;
import static com.example.makemoneyfromcreditcard.Splash_screen.str4;
import static com.example.makemoneyfromcreditcard.Splash_screen.str7;
import static com.example.makemoneyfromcreditcard.Utils2.Global.isNetworkAvailable;
import static com.facebook.ads.AudienceNetworkAds.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.makemoneyfromcreditcard.Utils2.AdEventListener;
import com.example.makemoneyfromcreditcard.Utils2.AdmobAdManager;
import com.facebook.ads.Ad;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.List;

public class SliderTwo extends AppCompatActivity {

    TextView slider2_next;
    ImageView before1;
    private NativeAd nativeAd;
    public FrameLayout native_ad_layout;
    LinearLayout gBannerAds,banner_container;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private  boolean key = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_two);

        if (str1.equals("g") )
        {

            New_Google_Banner();
        }
        else
        {
            New_FB_Banner();
        }


        slider2_next = findViewById(R.id.slider2_next);
        before1 = findViewById(R.id.before1);

        native_ad_layout = findViewById(R.id.nativeAd);
        gBannerAds = findViewById(R.id.gBannerAds);
        banner_container = findViewById(R.id.banner_container);


        slider2_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!key) {
                    key = true;

                    if (str1.equals("g")) {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {
                                final ProgressDialog progress;

                                progress = ProgressDialog.show(SliderTwo.this, SliderTwo.this.getString(R.string.app_name),
                                        SliderTwo.this.getString(R.string.ads_loader), true);


                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(SliderTwo.this, str4, adRequest,
                                        new InterstitialAdLoadCallback() {
                                            @Override
                                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                // The mInterstitialAd reference will be null until
                                                // an ad is loaded.
                                                progress.dismiss();

                                                interstitialAd.show(SliderTwo.this);
                                                interstitialAd.setFullScreenContentCallback(
                                                        new FullScreenContentCallback() {
                                                            @Override
                                                            public void onAdDismissedFullScreenContent() {
                                                                progress.dismiss();

                                                                Intent intent = new Intent(SliderTwo.this, SliderThree.class);
                                                                startActivity(intent);
                                                                key = false;


                                                            }

                                                            @Override
                                                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                progress.dismiss();

                                                                Intent intent = new Intent(SliderTwo.this, SliderTwo.class);
                                                                startActivity(intent);
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

                                                Intent intent = new Intent(SliderTwo.this, SliderThree.class);
                                                startActivity(intent);
                                                key = false;


                                            }
                                        });
                            } else {
                                Intent intent = new Intent(SliderTwo.this,SliderThree.class);
                                startActivity(intent);
                                key = false;

                            }

                        } else {
                            Intent intent = new Intent(SliderTwo.this,SliderThree.class);
                            startActivity(intent);
                            key = false;

                        }
                    } else {
                        if (isNetworkAvailable()) {
                            if (!str4.equals("")) {

                                final ProgressDialog progress;
                                progress = ProgressDialog.show(SliderTwo.this,
                                        getString(R.string.app_name),
                                        getString(R.string.ads_loader), true);

                                AdSettings.addTestDevice(getString(R.string.fb_testing));
                                // Instantiate an InterstitialAd object.
                                // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
                                // now, while you are testing and replace it later when you have signed up.
                                // While you are using this temporary code you will only get test ads and if you release
                                // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
                                interstitialAd = new com.facebook.ads.InterstitialAd(SliderTwo.this, str4);
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
                                        Intent intent = new Intent(SliderTwo.this,SliderThree.class);
                                        startActivity(intent);
                                        key = false;

                                    }

                                    @Override
                                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                                        // Ad error callback
                                        progress.dismiss();
                                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());

                                        Intent intent = new Intent(SliderTwo.this,SliderThree.class);
                                        startActivity(intent);
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
                                Intent intent = new Intent(SliderTwo.this, SliderThree.class);
                                startActivity(intent);
                                key = false;

                            }

                        } else {
                            Intent intent = new Intent(SliderTwo.this, SliderThree.class);
                            startActivity(intent);
                            key = false;

                        }

                    }
                }
            }
        });

        before1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        if(str1.equals("g") )
        {


            if (AdmobAdManager.getInstance().isAdLoadProcessing) {

                AdmobAdManager.getInstance().adEventListener = new AdEventListener() {
                    @Override
                    public void onAdLoaded(Object object) {
                        AdmobAdManager.getInstance().populateNativeAdView( SliderTwo.this, native_ad_layout, (com.google.android.gms.ads.nativead.NativeAd)object);
                        AdmobAdManager.getInstance().LoadNativeAd(SliderTwo.this, str2);
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
                    AdmobAdManager.getInstance().populateNativeAdView(SliderTwo.this, native_ad_layout, AdmobAdManager.getInstance().mNativeAd);
                    AdmobAdManager.getInstance().LoadNativeAd(SliderTwo.this, str2);
                }
            }

        }
        else
        {

            Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
            FbNativeAd();

        }


    }

    //********************************Facebook native **************************************************************
    private NativeAdLayout nativeAdLayout1;
    private LinearLayout adView1;
    private NativeAd nativeAd1_;


    private void FbNativeAd() {
        AdSettings.addTestDevice(getString(R.string.fb_testing));

        nativeAdLayout1 = findViewById(R.id.native_ad_container);

        // Instantiate a NativeAd object.
        // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
        // now, while you are testing and replace it later when you have signed up.
        // While you are using this temporary code you will only get test ads and if you release
        // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
        nativeAd1_ = new NativeAd(this, str2);
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

    private void inflateAd(NativeAd nativeAd) {

        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        LayoutInflater inflater = LayoutInflater.from(SliderTwo.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView1 = (LinearLayout) inflater.inflate(R.layout.fb_native_ad, nativeAdLayout1, false);
        nativeAdLayout1.addView(adView1);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container1);
        AdOptionsView adOptionsView = new AdOptionsView(SliderTwo.this, nativeAd, nativeAdLayout1);
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
    //**********************************facebook native over ************************************************************

    private AdView adView;

    public void New_Google_Banner(){

        gBannerAds = findViewById(R.id.gBannerAds);

        adView = new AdView(this);
        adView.setAdUnitId(str7);
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
        adView2 = new com.facebook.ads.AdView(this, str7, com.facebook.ads.AdSize.BANNER_HEIGHT_50);

// Find the Ad Container


// Add the ad view to your activity layout
        banner_container.addView(adView2);

// Request an ad
        adView2.loadAd();


    }

    //**********************************facebook banner over ********************************************************


}