package com.example.bloodpressure.Utils2;

public interface AdEventListener {
    void onAdLoaded(Object object);
    void onAdClosed();
    void onLoadError(String errorCode);
}