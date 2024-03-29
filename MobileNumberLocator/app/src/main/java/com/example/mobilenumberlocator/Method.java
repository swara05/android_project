package com.example.mobilenumberlocator;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Method {

//    @GET("Server_list")
//    Call<MultipleResource> doGetListResources(@Header("Authorization") String headerValue);

    @GET("number_verification/validate")
    Call<ModalLocation> getUsers(@Query("number") String number);

}
