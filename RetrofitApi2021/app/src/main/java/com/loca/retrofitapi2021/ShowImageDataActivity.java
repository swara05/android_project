package com.loca.retrofitapi2021;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.loca.retrofitapi2021.Api.RestAdsApi;
import com.loca.retrofitapi2021.Pojo.Data;
import com.loca.retrofitapi2021.Pojo.Icallscreen;
import com.loca.retrofitapi2021.Utils.GlobalRetro;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;

public class ShowImageDataActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    ArrayList<Data> dataArrayList = new ArrayList<>();
        private ArrayList<Data> arraylist = new ArrayList<>();
    private ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image_data);

        listview = findViewById(R.id.listview);

        getAds();
    }

    private void getAds() {

        pDialog = new ProgressDialog(ShowImageDataActivity.this);
        pDialog.setMessage("Please Wait");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
        RestAdsApi restApi = GlobalRetro.initRetrofit1(ShowImageDataActivity.this);
        Call<Icallscreen> categoryListCall = restApi.DO_URL_DATA("0");
        categoryListCall.enqueue(new Callback<Icallscreen>() {
            @SuppressLint("MissingPermission")
            @Override
            public void onResponse(Call<Icallscreen> call, retrofit2.Response<Icallscreen> response) {
                Log.d("my", response.body() + "");
                if (response.body() != null) {
                    pDialog.dismiss();

                    if (response.body().getStatus().equals("true")) {

                        arraylist = response.body().getData();
                        Log.d("getData", arraylist + "");

                        CustomAdapter adapter = new CustomAdapter(ShowImageDataActivity.this, arraylist);
                        listview.setAdapter(adapter);

                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<Icallscreen> call, Throwable t) {
                Log.d("Piyush", t + "");
                pDialog.dismiss();
                GlobalRetro.showToast(ShowImageDataActivity.this, "Something went to wrong");
            }
        });
    }

}