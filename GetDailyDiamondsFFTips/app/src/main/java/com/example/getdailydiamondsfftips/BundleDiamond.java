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

public class BundleDiamond extends AppCompatActivity {

    ImageView back,bundleimg;
    TextView bundleinfo,bundleheading;

    private RelativeLayout adlayout;
    public FrameLayout native_ad_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_diamond);

        back = findViewById(R.id.back);
        bundleimg = findViewById(R.id.bundleimg);
        bundleheading = findViewById(R.id.bundleheading);
        bundleinfo = findViewById(R.id.bundleinfo);
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

        String bun = getIntent().getStringExtra("bundle");

        bundleheading.setText(bun);

        if(bun.equals("Zombie Samurai Bundle")){
            bundleimg.setImageResource(R.drawable.zombie);
            bundleinfo.setText(R.string.des_zombified);
        }else if(bun.equals("Arctic Blue Bundle")){
            bundleimg.setImageResource(R.drawable.arctic);
            bundleinfo.setText(R.string.des_artic);
        }else if(bun.equals("Green Criminal Bundle")){
            bundleimg.setImageResource(R.drawable.green);
            bundleinfo.setText(R.string.des_greencriminal);
        }else if(bun.equals("Bunny Warrior Bundle")){
            bundleimg.setImageResource(R.drawable.bunny);
            bundleinfo.setText(R.string.des_bunny);
        }else if(bun.equals("Crazy Panda Bundle")){
            bundleimg.setImageResource(R.drawable.crazypanda);
            bundleinfo.setText(R.string.des_crazy);
        }else if(bun.equals("Galaxy Dino Bundle")){
            bundleimg.setImageResource(R.drawable.galaxy);
            bundleinfo.setText(R.string.des_galaxy);
        }else if(bun.equals("Electric Shock Bundle")){
            bundleimg.setImageResource(R.drawable.electric);
            bundleinfo.setText(R.string.des_electric);
        }else if(bun.equals("Iron Blade Bundle")){
            bundleimg.setImageResource(R.drawable.iron);
            bundleinfo.setText(R.string.des_iron);
        }else if(bun.equals("Purple Shade Bundle")){
            bundleimg.setImageResource(R.drawable.purple);
            bundleinfo.setText(R.string.des_purshade);
        }else if(bun.equals("Sakura Bundle")){
            bundleimg.setImageResource(R.drawable.sakura);
            bundleinfo.setText(R.string.des_sakura);
        }else if(bun.equals("Breakdancer Bundle")){
            bundleimg.setImageResource(R.drawable.breakdancer);
            bundleinfo.setText(R.string.des_breakdance);
        }else if(bun.equals("Joker Bundle")){
            bundleimg.setImageResource(R.drawable.joker);
            bundleinfo.setText(R.string.des_joker);
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
                    AdmobAdManager.getInstance().populateNativeAdView( BundleDiamond.this, native_ad_layout, (com.google.android.gms.ads.nativead.NativeAd)object);
                    AdmobAdManager.getInstance().LoadNativeAd(BundleDiamond.this, str2);
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
                AdmobAdManager.getInstance().populateNativeAdView(BundleDiamond.this, native_ad_layout, AdmobAdManager.getInstance().mNativeAd);
                AdmobAdManager.getInstance().LoadNativeAd(BundleDiamond.this, str2);
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
        LayoutInflater inflater = LayoutInflater.from(BundleDiamond.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView1 = (LinearLayout) inflater.inflate(R.layout.fb_native_ad, nativeAdLayout1, false);
        nativeAdLayout1.addView(adView1);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container1);
        AdOptionsView adOptionsView = new AdOptionsView(BundleDiamond.this, nativeAd, nativeAdLayout1);
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