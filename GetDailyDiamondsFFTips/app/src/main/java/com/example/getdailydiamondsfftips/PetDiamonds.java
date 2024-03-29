package com.example.getdailydiamondsfftips;

import static com.example.getdailydiamondsfftips.Splash_screen.str1;
import static com.example.getdailydiamondsfftips.Splash_screen.str2;

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

public class PetDiamonds extends AppCompatActivity {

    ImageView back,petimg;
    TextView petheading,petdetails;
    private RelativeLayout adlayout;
    public FrameLayout native_ad_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_diamonds);

        back = findViewById(R.id.back);
        petimg = findViewById(R.id.petimg);
        petheading = findViewById(R.id.petheading);
        petdetails = findViewById(R.id.petdetails);
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

        String p = getIntent().getStringExtra("pet");

        petheading.setText(p);

        if(p.equals("DERKI PET")){
            petimg.setImageResource(R.drawable.derki);
            petdetails.setText(R.string.derki_des);
        }else if(p.equals("DRAGON PET")){
            petimg.setImageResource(R.drawable.dragon);
            petdetails.setText(R.string.dragon_pet_des);
        }else if(p.equals("ROBO PET")){
            petimg.setImageResource(R.drawable.robo);
            petdetails.setText(R.string.robo_des);
        }else if(p.equals("MOONY PET")){
            petimg.setImageResource(R.drawable.moony);
            petdetails.setText(R.string.moony_des);
        }else if(p.equals("OTTERO PET")){
            petimg.setImageResource(R.drawable.ottero);
            petdetails.setText(R.string.ottero_des);
        }else if(p.equals("PANDA PET")){
            petimg.setImageResource(R.drawable.panda);
            petdetails.setText(R.string.panda_des);
        }else if(p.equals("PORING PET")){
            petimg.setImageResource(R.drawable.poring);
            petdetails.setText(R.string.poring_des);
        }else if(p.equals("FALCO PET")){
            petimg.setImageResource(R.drawable.falco);
            petdetails.setText(R.string.falco_des);
        }else if(p.equals("SHIBA PET")){
            petimg.setImageResource(R.drawable.shiba);
            petdetails.setText(R.string.shiba_des);
        }else if(p.equals("MR.WAGGOR PET")){
            petimg.setImageResource(R.drawable.waggor);
            petdetails.setText(R.string.waggor_des);
        }else if(p.equals("SPIRIT FOX PET")){
            petimg.setImageResource(R.drawable.fox);
            petdetails.setText(R.string.spirit_des);
        }else if(p.equals("ROCKIE PET")){
            petimg.setImageResource(R.drawable.rockie);
            petdetails.setText(R.string.rockie_des);
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
                    AdmobAdManager.getInstance().populateNativeAdView( PetDiamonds.this, native_ad_layout, (com.google.android.gms.ads.nativead.NativeAd)object);
                    AdmobAdManager.getInstance().LoadNativeAd(PetDiamonds.this, str2);
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
                AdmobAdManager.getInstance().populateNativeAdView(PetDiamonds.this, native_ad_layout, AdmobAdManager.getInstance().mNativeAd);
                AdmobAdManager.getInstance().LoadNativeAd(PetDiamonds.this, str2);
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
        LayoutInflater inflater = LayoutInflater.from(PetDiamonds.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView1 = (LinearLayout) inflater.inflate(R.layout.fb_native_ad, nativeAdLayout1, false);
        nativeAdLayout1.addView(adView1);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container1);
        AdOptionsView adOptionsView = new AdOptionsView(PetDiamonds.this, nativeAd, nativeAdLayout1);
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