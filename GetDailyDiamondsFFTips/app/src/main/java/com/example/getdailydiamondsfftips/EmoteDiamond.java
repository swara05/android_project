package com.example.getdailydiamondsfftips;

import static com.example.getdailydiamondsfftips.Splash_screen.str1;
import static com.example.getdailydiamondsfftips.Splash_screen.str2;
import static com.example.getdailydiamondsfftips.Splash_screen.str5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getdailydiamondsfftips.Utils2.AdEventListener;
import com.example.getdailydiamondsfftips.Utils2.AdmobAdManager;
import com.facebook.ads.Ad;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;

import java.util.ArrayList;
import java.util.List;

public class EmoteDiamond extends AppCompatActivity {

    ImageView back,emoteimg;
    TextView emoteheading,emoteinfo;
    private RelativeLayout adlayout;
    public FrameLayout native_ad_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emote_diamond);

        back = findViewById(R.id.back);
        emoteimg = findViewById(R.id.emoteimg);
        emoteheading = findViewById(R.id.emoteheading);
        emoteinfo = findViewById(R.id.emoteinfo);
        native_ad_layout = findViewById(R.id.nativeAd);

        adlayout = findViewById(R.id.adlayout);

        if (str2.equals("")) {
            adlayout.setVisibility(View.GONE);

        } else {
            adlayout.setVisibility(View.VISIBLE);

        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String e = getIntent().getStringExtra("emote");

        emoteheading.setText(e);

        if(e.equals("ANGRY EMOTE")){
            emoteimg.setImageResource(R.drawable.angry);
            emoteinfo.setText(R.string.angry_emote);
        }else if(e.equals("APPLAUSE EMOTE")){
            emoteimg.setImageResource(R.drawable.applause);
            emoteinfo.setText(R.string.applause_emote);
        }else if(e.equals("BYE BYE EMOTE")){
            emoteimg.setImageResource(R.drawable.byebye);
            emoteinfo.setText(R.string.bye_emote);
        }else if(e.equals("DANCE EMOTE")){
            emoteimg.setImageResource(R.drawable.dance);
            emoteinfo.setText(R.string.dance_emote);
        }else if(e.equals("FIREWORK EMOTE")){
            emoteimg.setImageResource(R.drawable.firework);
            emoteinfo.setText(R.string.firework_emote);
        }else if(e.equals("FLEX EMOTE")){
            emoteimg.setImageResource(R.drawable.flex);
            emoteinfo.setText(R.string.flex_emote);
        }else if(e.equals("HEART EMOTE")){
            emoteimg.setImageResource(R.drawable.heart);
            emoteinfo.setText(R.string.heart_emote);
        }else if(e.equals("HELLO EMOTE")){
            emoteimg.setImageResource(R.drawable.hello);
            emoteinfo.setText(R.string.hello_emote);
        }else if(e.equals("THUMBS UP EMOTE")){
            emoteimg.setImageResource(R.drawable.thumpsup);
            emoteinfo.setText(R.string.thumpup_emote);
        }else if(e.equals("HUG EMOTE")){
            emoteimg.setImageResource(R.drawable.hug);
            emoteinfo.setText(R.string.hug_emote);
        }else if(e.equals("KISS EMOTE")){
            emoteimg.setImageResource(R.drawable.kiss);
            emoteinfo.setText(R.string.kiss_emote);
        }else if(e.equals("LAUGHING EMOTE")){
            emoteimg.setImageResource(R.drawable.laugh);
            emoteinfo.setText(R.string.laughing_emote);
        }
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
                    AdmobAdManager.getInstance().populateNativeAdView( EmoteDiamond.this, native_ad_layout, (com.google.android.gms.ads.nativead.NativeAd)object);
                    AdmobAdManager.getInstance().LoadNativeAd(EmoteDiamond.this, str2);
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
                AdmobAdManager.getInstance().populateNativeAdView(EmoteDiamond.this, native_ad_layout, AdmobAdManager.getInstance().mNativeAd);
                AdmobAdManager.getInstance().LoadNativeAd(EmoteDiamond.this, str5);
            }
        }
    }


    //********************************Facebook native **************************************************************
    private NativeAdLayout nativeAdLayout1;
    private LinearLayout adView1;
    private com.facebook.ads.NativeAd nativeAd1_;

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
        LayoutInflater inflater = LayoutInflater.from(EmoteDiamond.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView1 = (LinearLayout) inflater.inflate(R.layout.fb_native_ad, nativeAdLayout1, false);
        nativeAdLayout1.addView(adView1);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container1);
        AdOptionsView adOptionsView = new AdOptionsView(EmoteDiamond.this, nativeAd, nativeAdLayout1);
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