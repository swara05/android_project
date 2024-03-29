package com.example.apicalling;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Method {
    @FormUrlEncoded
    @POST("api/getData")
    Call<MyPojo> getUserData(@Field("type") String imagename);
}
