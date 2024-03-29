package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        listData();
    }

    private void listData() {

        Method retroapi = RetrofitApi.initRetrofit(this);
        Call<Modal> listData =retroapi.getData("198");
        listData.enqueue(new Callback<Modal>() {
            @Override
            public void onResponse(Call<Modal> call, Response<Modal> response) {

                Log.d("Data", String.valueOf(response.body()));

                ArrayList<Data> userList = new ArrayList<>();
              userList.add(response.body().getData());
                RecyclerView.Adapter adapter = new AdapterApi(userList,MainActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Modal> call, Throwable t) {
                Log.e("ERROR",t.toString());
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}