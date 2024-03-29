package com.loca.retrofitapi2021;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.loca.retrofitapi2021.Api.RestAdsApi;
import com.loca.retrofitapi2021.Pojo.Coingecko.Coingecko;
import com.loca.retrofitapi2021.Pojo.Icallscreen;
import com.loca.retrofitapi2021.Utils.GlobalRetro;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainGetDataActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    private List<Coingecko> arraylist = new ArrayList<>();
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_get_data);

        getDO_COIN_CKO();
    }

    private void getDO_COIN_CKO() {

        pDialog = new ProgressDialog(MainGetDataActivity.this);
        pDialog.setMessage("Please Wait");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
        RestAdsApi restApi = GlobalRetro.initRetrofit2(MainGetDataActivity.this);
        Call <List<Coingecko>> categoryListCall = restApi.DO_COIN_CKO("usd");
        categoryListCall.enqueue(new Callback <List<Coingecko>>() {
            @SuppressLint("MissingPermission")
            @Override
            public void onResponse(Call <List<Coingecko>> call, retrofit2.Response <List<Coingecko>>response) {
                Log.d("my", response.body() + "");
                if (response.body() != null) {
                    pDialog.dismiss();


                        arraylist = response.body();

                       id =  arraylist.get(0).getId();


                        Log.d("coin", id + "");
                    Toast.makeText(MainGetDataActivity.this, ""+id, Toast.LENGTH_SHORT).show();

                      /*  CustomAdapter adapter = new CustomAdapter(MainGetDataActivity.this, arraylist);
                        listview.setAdapter(adapter);*/


                } else {

                }
            }

            @Override
            public void onFailure(Call <List<Coingecko>>call, Throwable t) {
                Log.d("Piyush", t + "");
                pDialog.dismiss();
                GlobalRetro.showToast(MainGetDataActivity.this, "Something went to wrong");
            }
        });
    }


}