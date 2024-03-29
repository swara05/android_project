package com.example.api;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Method {

    @FormUrlEncoded
    @POST("app/api/ads")
    Call<Modal> getData(@Field("package_name")String google_native);
}
