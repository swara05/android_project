package com.example.bloodpressure.Api;


import com.example.bloodpressure.Pojo.Counter.Counter;
import com.example.bloodpressure.Pojo.Devtesting;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestAdsApi {
//
//    public static final String BASE_URL1 = "https://www.dailycryptocurrency.trade/";
//   public static final String AdsShow_URL = "new/api/ads";
//   public static final String Counter_URL = "new/api/userlist/download";

    public static final String BASE_URL1 = "https://devtesting.club/";
    public static final String AdsShow_URL = "app/api/ads";
   public static final String Counter_URL = "app/api/userlist/download";
    /*
               r19 = this;
               r0 = r19
               super.onCreate(r20)
               java.lang.String r1 = "speedometer_preferences"
               r2 = 0
               android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r2)
               r0.preferences = r1
               java.lang.String r3 = "darkMode"
               r4 = 1
               boolean r1 = r1.getBoolean(r3, r4)
               r0.dark_mode = r1
               java.lang.String r3 = "burgundy"
               java.lang.String r5 = "displayColor"
               java.lang.String r6 = "bgColor"
               java.lang.String r7 = "black"
               java.lang.String r8 = "skin"
               java.lang.String r9 = "red"
               if (r1 == 0) goto L_0x0036
               android.content.SharedPreferences r1 = r0.preferences
               java.lang.String r1 = r1.getString(r6, r7)
               r0.bgColor = r1
               android.content.SharedPreferences r1 = r0.preferences
               java.lang.String r1 = r1.getString(r5, r9)
               r0.displayColor = r1
               goto L_0x0046
           L_0x0036:
               android.content.SharedPreferences r1 = r0.preferences
               java.lang.String r1 = r1.getString(r6, r8)
               r0.bgColor = r1
               android.content.SharedPreferences r1 = r0.preferences
               java.lang.String r1 = r1.getString(r5, r3)
               r0.displayColor = r1*/
//    @FormUrlEncoded
//    @POST(AdsShow_URL)
//    Call<Devtesting> DO_URL_DATA(@Field("package_name") String package_name, @Field("token") String token);

    @FormUrlEncoded
    @POST(AdsShow_URL)
    Call<Devtesting> DO_URL_DATA(@Field("package_name") String package_name);

    @FormUrlEncoded
    @POST(Counter_URL)
    Call<Counter> doCounter_URL_Data(@Field("package_name") String package_name);
}

