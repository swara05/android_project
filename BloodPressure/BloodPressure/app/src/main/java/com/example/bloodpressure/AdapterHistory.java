package com.example.bloodpressure;

import static com.example.bloodpressure.SplashScreen.str1;
import static com.example.bloodpressure.SplashScreen.str2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bloodpressure.Utils2.AdEventListener;
import com.example.bloodpressure.Utils2.AdmobAdManager;
import com.facebook.ads.Ad;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.gms.ads.nativead.NativeAd;

import java.util.ArrayList;
import java.util.List;

    public class AdapterHistory extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private ArrayList<ModalHistory> userList;
        private Context context;
        private static final int Ad_type = 2;
        private static final int Item_type = 1;
        private NativeAd nativeAd;

        FrameLayout frameLayout;
        NativeAdLayout nativeAdLayout1;
        LinearLayout adChoicesContainer;




        public AdapterHistory(ArrayList<ModalHistory> userList, Context context) {
            this.userList = userList;
            this.context = context;
        }


        @Override
        public int getItemViewType(int i) {
            if ((i + 1) % 6 == 0) {
                return Ad_type;
            } else {
                return Item_type;
            }
        }


        public class adViewHolder extends RecyclerView.ViewHolder {


            RelativeLayout ll_AdsHide;

            public adViewHolder(@NonNull View itemView) {
                super(itemView);

                frameLayout = itemView.findViewById(R.id.nativeAd);
                ll_AdsHide = itemView.findViewById(R.id.llAds);
                nativeAdLayout1 = itemView.findViewById(R.id.native_ad_container);
                adChoicesContainer = itemView.findViewById(R.id.ad_choices_container1);

                if (str2.equals("")) {
                    ll_AdsHide.setVisibility(View.GONE);
                } else {
                    ll_AdsHide.setVisibility(View.VISIBLE);
                }
            }

        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (viewType == Ad_type) {
                return new adViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ads, parent, false));
            } else {
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false));
            }
        }


        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

            holder.setIsRecyclable(false);


            if (getItemViewType(position) == Item_type) {
                int pos = position - Math.round(position / 7);

                ViewHolder view = (ViewHolder) holder;

                ModalHistory modal = userList.get(position);

                if (modal.getHsys() == null) {
                    ((ViewHolder) holder).hsys.setText("100");

                } else {
                    ((ViewHolder) holder).hsys.setText(userList.get(position).getHsys());
                }
                if (modal.getHdis() == null) {
                    ((ViewHolder) holder).hdis.setText("75");
                } else {
                    ((ViewHolder) holder).hdis.setText(userList.get(position).getHdis());
                }
                if (modal.getHpls() == null) {
                    ((ViewHolder) holder).hpls.setText("70");
                } else {
                    ((ViewHolder) holder).hpls.setText(userList.get(position).getHpls());
                }

                if(modal.getHstatus() == null){
                    ((ViewHolder) holder).hstatus.setText("◉ Normal");
                }else{
                    ((ViewHolder) holder).hstatus.setText(userList.get(position).getHstatus());
                }

                if (modal.getHstatus() == null) {
                    ((ViewHolder) holder).hstatus.setTextColor(ContextCompat.getColor(context, R.color.green));
                } else if (modal.getHstatus().equals("◉ Hypotension")) {
                    ((ViewHolder) holder).hstatus.setTextColor(ContextCompat.getColor(context, R.color.blue));
                } else if (modal.getHstatus().equals("◉ Normal")) {
                    ((ViewHolder) holder).hstatus.setTextColor(ContextCompat.getColor(context, R.color.green));
                } else if (modal.getHstatus().equals("◉ Elevated")) {
                    ((ViewHolder) holder).hstatus.setTextColor(ContextCompat.getColor(context, R.color.light_yello));
                } else if (modal.getHstatus().equals("◉ Hypertension Stage 1")) {
                    ((ViewHolder) holder).hstatus.setTextColor(ContextCompat.getColor(context, R.color.yellow));
                } else if (modal.getHstatus().equals("◉ Hypertension Stage 2")) {
                    ((ViewHolder) holder).hstatus.setTextColor(ContextCompat.getColor(context, R.color.orange));
                } else if (modal.getHstatus().equals("◉ Hypertensive Crisis")) {
                    ((ViewHolder) holder).hstatus.setTextColor(ContextCompat.getColor(context, R.color.red));
                } else {
                    ((ViewHolder) holder).hstatus.setTextColor(ContextCompat.getColor(context, R.color.green));
                }

                ((ViewHolder) holder).hdate.setText(userList.get(position).getHdate());
                ((ViewHolder) holder).htime.setText(userList.get(position).getHtime());
                ((ViewHolder) holder).htag.setText((CharSequence) userList.get(position).getHtag());


            } else if (getItemViewType(position) == Ad_type) {


                if (str1.equals("g")) {


                    if (AdmobAdManager.getInstance().isAdLoadProcessing) {
                        AdmobAdManager.getInstance().adEventListener = new AdEventListener() {
                            @Override
                            public void onAdLoaded(Object object) {
                                AdmobAdManager.getInstance().populateNativeAdView(context, frameLayout, (NativeAd) object);
                                AdmobAdManager.getInstance().LoadNativeAd(context, str2);
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
                            AdmobAdManager.getInstance().populateNativeAdView(context, frameLayout, AdmobAdManager.getInstance().mNativeAd);
                            AdmobAdManager.getInstance().LoadNativeAd(context, str2);
                        }
                    }
                } else {


                    FbNativeAd();
                    Log.e("TAG", "onBindViewHolder: fb native ads display here");
                }

            }


        }


        //********************************Facebook native **************************************************************

        LinearLayout adView1;
        com.facebook.ads.NativeAd nativeAd1_;

        private void FbNativeAd() {
            AdSettings.addTestDevice(context.getString(R.string.fb_testing));


            // Instantiate a NativeAd object.
            // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
            // now, while you are testing and replace it later when you have signed up.
            // While you are using this temporary code you will only get test ads and if you release
            // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
            nativeAd1_ = new com.facebook.ads.NativeAd(context, str2);
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
            LayoutInflater inflater = LayoutInflater.from(context);
            // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
            adView1 = (LinearLayout) inflater.inflate(R.layout.fb_native_ad, nativeAdLayout1, false);
            nativeAdLayout1.addView(adView1);

            // Add the AdOptionsView

            AdOptionsView adOptionsView = new AdOptionsView(context, nativeAd, nativeAdLayout1);
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

        //********************************Facebook native over **************************************************************


        @Override
        public int getItemCount() {
            return userList.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {


            private TextView hdate, htime, hsys, hdis, hpls, htag, hstatus;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                hdate = itemView.findViewById(R.id.hdate);
                htime = itemView.findViewById(R.id.htime);
                hsys = itemView.findViewById(R.id.hsys);
                hdis = itemView.findViewById(R.id.hdis);
                hpls = itemView.findViewById(R.id.hpls);
                htag = itemView.findViewById(R.id.htag);
                hstatus = itemView.findViewById(R.id.hstatus);

            }
        }


    }

