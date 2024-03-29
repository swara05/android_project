package com.example.bloodpressure.Utils2;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.bloodpressure.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;

import java.util.Objects;


public class AdmobAdManager {

    private final String TAG = "AdmobAdManager";
    private static AdmobAdManager singleton;
    public InterstitialAd interstitialAd;
    public boolean isAdLoad = false;
    public boolean isAdLoadProcessing = false;

    public boolean isAdLoadFailed = false;

    private ProgressDialog progressDialog;
    public NativeAd mNativeAd;
    public AdEventListener adEventListener;
    public int mCurrentAdShow = 0;

    public static AdmobAdManager getInstance() {
        if (singleton == null) {
            singleton = new AdmobAdManager();
        }
        return singleton;
    }


    public boolean isNetworkAvailable(Context c) {
        ConnectivityManager manager = (ConnectivityManager)
                c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    public void LoadNativeAd(final Context context, String nativeAdID) {
        AdLoader.Builder builder = new AdLoader.Builder(context, nativeAdID);
        isAdLoadProcessing = true;
        builder.forNativeAd(unifiedNativeAd -> {
            mNativeAd = unifiedNativeAd;
            if (adEventListener != null) {
                adEventListener.onAdLoaded(unifiedNativeAd);
            }
            isAdLoadProcessing = false;
        }).withAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                if (adEventListener != null) {
                    adEventListener.onLoadError(loadAdError.getMessage());
                }
                isAdLoadProcessing = false;
                Log.e(TAG, "onAdFailedToLoadNative:" + loadAdError.getCode());
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }
        });
        VideoOptions videoOptions = new VideoOptions.Builder()
                .setStartMuted(true)
                .build();
        NativeAdOptions adOptions = new NativeAdOptions.Builder().setVideoOptions(videoOptions).build();
        builder.withNativeAdOptions(adOptions);
        AdLoader adLoader = builder.build();
        adLoader.loadAd(new AdRequest.Builder().build());

    }




    public void populateNativeAdView(Context context, FrameLayout frameLayout, NativeAd nativeAd) {
        if (isNetworkAvailable(context)) {
            LayoutInflater inflater = LayoutInflater.from(context);
            NativeAdView adView = (NativeAdView) inflater.inflate( R.layout.ad_unit2, null);

            if (frameLayout != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(adView);
                frameLayout.setVisibility(View.VISIBLE);
            }
            try {
                adView.setMediaView((MediaView) adView.findViewById( R.id.ad_media));
                adView.setHeadlineView(adView.findViewById( R.id.ad_headline));
                adView.setBodyView(adView.findViewById( R.id.ad_body));
                adView.setCallToActionView(adView.findViewById( R.id.ad_call_to_action));
                adView.setIconView(adView.findViewById( R.id.ad_app_icon));
                adView.setPriceView(adView.findViewById( R.id.ad_price));
                adView.setStarRatingView(adView.findViewById( R.id.ad_stars));
                adView.setStoreView(adView.findViewById( R.id.ad_store));
                adView.setAdvertiserView(adView.findViewById( R.id.ad_advertiser));


                ((TextView) Objects.requireNonNull(adView.getHeadlineView())).setText(nativeAd.getHeadline());
                Objects.requireNonNull(adView.getMediaView()).setMediaContent(Objects.requireNonNull(nativeAd.getMediaContent()));


                if (nativeAd.getBody() == null) {
                    Objects.requireNonNull(adView.getBodyView()).setVisibility(View.INVISIBLE);

                } else {
                    adView.getBodyView().setVisibility(View.VISIBLE);
                    ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
                }
                if (nativeAd.getCallToAction() == null) {
                    Objects.requireNonNull(adView.getCallToActionView()).setVisibility(View.INVISIBLE);
                } else {
                    Objects.requireNonNull(adView.getCallToActionView()).setVisibility(View.VISIBLE);
                    ((TextView) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
                }
                if (nativeAd.getIcon() == null) {
                    Objects.requireNonNull(adView.getIconView()).setVisibility(View.GONE);
                } else {
                    ((ImageView) Objects.requireNonNull(adView.getIconView())).setImageDrawable(nativeAd.getIcon().getDrawable());
                    adView.getIconView().setVisibility(View.VISIBLE);
                }

                if (nativeAd.getPrice() == null) {
                    Objects.requireNonNull(adView.getPriceView()).setVisibility(View.INVISIBLE);

                } else {
                    Objects.requireNonNull(adView.getPriceView()).setVisibility(View.VISIBLE);
                    ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
                }
                if (nativeAd.getStore() == null) {
                    Objects.requireNonNull(adView.getStoreView()).setVisibility(View.INVISIBLE);
                } else {
                    Objects.requireNonNull(adView.getStoreView()).setVisibility(View.VISIBLE);
                    ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
                }
                if (nativeAd.getStarRating() == null) {
                    Objects.requireNonNull(adView.getStarRatingView()).setVisibility(View.INVISIBLE);
                } else {
                    ((RatingBar) Objects.requireNonNull(adView.getStarRatingView())).setRating(nativeAd.getStarRating().floatValue());
                    adView.getStarRatingView().setVisibility(View.VISIBLE);
                }

                if (nativeAd.getAdvertiser() == null) {
                    Objects.requireNonNull(adView.getAdvertiserView()).setVisibility(View.INVISIBLE);
                } else
                    ((TextView) Objects.requireNonNull(adView.getAdvertiserView())).setText(nativeAd.getAdvertiser());
                adView.getAdvertiserView().setVisibility(View.VISIBLE);


                VideoController vc = nativeAd.getMediaContent().getVideoController();
                vc.mute(true);
                if (vc.hasVideoContent()) {
                    vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                        @Override
                        public void onVideoEnd() {
                            super.onVideoEnd();
                        }
                    });
                }


                adView.setNativeAd(nativeAd);

            } catch (Exception e) {
                e.printStackTrace();
                Log.e("TAG", "populateUnifiedNativeAdView Exception: " + e.getMessage());
            }
        }
    }




}
