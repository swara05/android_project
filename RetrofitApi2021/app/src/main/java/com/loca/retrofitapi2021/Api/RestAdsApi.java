package com.loca.retrofitapi2021.Api;

import com.loca.retrofitapi2021.Pojo.Coingecko.Coingecko;
import com.loca.retrofitapi2021.Pojo.Icallscreen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestAdsApi {

    public static final String BASE_URL1 = "http://icallscreen.in/wallpaper/";
    public static final String AdsShow_URL = "api/getData";

    @FormUrlEncoded
    @POST(AdsShow_URL)
    Call<Icallscreen> DO_URL_DATA(@Field("type") String type);


    public static final String BASE_URL2 = "https://api.coingecko.com/api/v3/coins/";
    public static final String coingecko = "markets?vs_currency=";

    @GET(coingecko)
    Call <List<Coingecko>> DO_COIN_CKO(@Query("vs_currency") String vs_currency);



}

