package com.example.mobilenumberlocator;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitApi {
    private static Retrofit retrofit = null;


    public static Retrofit getlocation() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("apikey", "fHSuevZjf6ng7GDwb0N0dN5UZhnSpKWP" )
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.apilayer.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
//
//
//        retrofit = new Retrofit.Builder()
//                .baseUrl("https://devtesting.club/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build();



        return retrofit;
    }

}


//package com.example.mobilenumberlocator;
//
//import android.content.Context;
//import android.widget.Toast;
//
//import java.io.IOException;
//
//import okhttp3.Interceptor;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//class RetrofitApi {
//
//    public static Retrofit initRetrofit(Context context){
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Interceptor.Chain chain) throws IOException {
//                Request original = chain.request();
//
//                Request request = original.newBuilder()
//                        .header("apikey", "fHSuevZjf6ng7GDwb0N0dN5UZhnSpKWP" )
//                        .method(original.method(), original.body())
//                        .build();
//
//                return chain.proceed(request);
//            }
//        });
//
//        OkHttpClient client = httpClient.build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.apilayer.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build();
//
//        return retrofit;
//    }
//
//    public static void showToast(Context ctx,String message){
//        Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();
//    }
//}
