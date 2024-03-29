package com.example.makemoneyfromcreditcard;

import static com.example.makemoneyfromcreditcard.Splash_screen.str1;
import static com.example.makemoneyfromcreditcard.Splash_screen.str2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.makemoneyfromcreditcard.Utils2.AdEventListener;
import com.example.makemoneyfromcreditcard.Utils2.AdmobAdManager;
import com.facebook.ads.Ad;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.gms.ads.nativead.NativeAd;

import java.util.ArrayList;
import java.util.List;

public class RedeemCashbackGift extends AppCompatActivity {

    ImageView b2;
    private RelativeLayout adlayout, adlayout2;
    public FrameLayout native_ad_layout, native_ad_layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_cashback_gift);

        b2 = findViewById(R.id.b2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

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

        if (AdmobAdManager.getInstance().isAdLoadProcessing2) {

            AdmobAdManager.getInstance().adEventListener = new AdEventListener() {
                @Override
                public void onAdLoaded(Object object) {
                    AdmobAdManager.getInstance().populateNativeAdView(RedeemCashbackGift.this, native_ad_layout2, (com.google.android.gms.ads.nativead.NativeAd) object);
                    AdmobAdManager.getInstance().LoadNativeAd(RedeemCashbackGift.this, str2);
                    AdmobAdManager.getInstance().adEventListener = null;
                }

                @Override
                public void onAdClosed() {
                }

                @Override
                public void onLoadError(String errorCode) {

                }
            };
        } else {
            if (AdmobAdManager.getInstance().mNativeAd2 != null) {
                //  Toast.makeText( , "loads2", Toast.LENGTH_SHORT ).show();
                AdmobAdManager.getInstance().populateNativeAdView2(RedeemCashbackGift.this, native_ad_layout2, AdmobAdManager.getInstance().mNativeAd2);
                AdmobAdManager.getInstance().LoadNativeAd2(RedeemCashbackGift.this, str2);
            }
        }
    }

    private void refreshAd() {
        if (AdmobAdManager.getInstance().isAdLoadProcessing) {

            AdmobAdManager.getInstance().adEventListener = new AdEventListener() {
                @Override
                public void onAdLoaded(Object object) {
                    AdmobAdManager.getInstance().populateNativeAdView(RedeemCashbackGift.this, native_ad_layout, (com.google.android.gms.ads.nativead.NativeAd) object);
                    AdmobAdManager.getInstance().LoadNativeAd(RedeemCashbackGift.this, str2);
                    AdmobAdManager.getInstance().adEventListener = null;
                }

                @Override
                public void onAdClosed() {
                }

                @Override
                public void onLoadError(String errorCode) {

                }
            };
        } else {
            if (AdmobAdManager.getInstance().mNativeAd != null) {
                //  Toast.makeText( , "loads2", Toast.LENGTH_SHORT ).show();
                AdmobAdManager.getInstance().populateNativeAdView(RedeemCashbackGift.this, native_ad_layout, AdmobAdManager.getInstance().mNativeAd);
                AdmobAdManager.getInstance().LoadNativeAd(RedeemCashbackGift.this, str2);
            }
        }
    }


    //********************************Facebook native **************************************************************
    private NativeAdLayout nativeAdLayout1, nativeAdLayout2;
    private LinearLayout adView1;
    private com.facebook.ads.NativeAd nativeAd1_, nativeAd2_;

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

    private void inflateAd2(com.facebook.ads.NativeAd nativeAd) {

        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        LayoutInflater inflater = LayoutInflater.from(RedeemCashbackGift.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView1 = (LinearLayout) inflater.inflate(R.layout.fb_native_ad, nativeAdLayout2, false);
        nativeAdLayout2.addView(adView1);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container1);
        AdOptionsView adOptionsView = new AdOptionsView(RedeemCashbackGift.this, nativeAd, nativeAdLayout2);
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
                inflateAd2(nativeAd2_);
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
        LayoutInflater inflater = LayoutInflater.from(RedeemCashbackGift.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView1 = (LinearLayout) inflater.inflate(R.layout.fb_native_ad, nativeAdLayout1, false);
        nativeAdLayout1.addView(adView1);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container1);
        AdOptionsView adOptionsView = new AdOptionsView(RedeemCashbackGift.this, nativeAd, nativeAdLayout1);
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