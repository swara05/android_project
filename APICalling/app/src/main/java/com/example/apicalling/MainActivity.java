package com.example.apicalling;

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

    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
       // recyclerview.setLayoutManager(linearLayoutManager);
        listingData();
//        imgname = findViewById(R.id.imgname);
//        btn = findViewById(R.id.btn);
//        output = findViewById(R.id.output);


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name;
//                name = imgname.getText().toString();
//
//                if(name == ""){
//                    imgname.setError("Please enter the data");
//                }else{
//                    Method method = RetrofitApi.getRetrofitInstance().create(Method.class);
//                    Call<Modalapi> call = method.getUserData("0");
//
//                    call.enqueue(new Callback<Modalapi>() {
//                        @Override
//                        public void onResponse(Call<Modalapi> call, Response<Modalapi> response) {
//                           // Log.d("DATA"+response.body());
//
//                            Log.e("TAG", "onResponse: " + response.body() );
//                            String strOutput = "";
//                            strOutput =  "Id : " + response.body().getId();
//                            strOutput = strOutput + "\nName : " + response.body().getImagename();
//                            strOutput = strOutput + "\nImage : " + response.body().getImage();
//                            strOutput = strOutput + "\nStatus : " + response.body().getStatus();
//                            strOutput = strOutput + "\nCreated At : " + response.body().getCreated();
//                            strOutput = strOutput + "\nUpdated At : " + response.body().getUpdated();
//                            output.setText(strOutput);
//                        }
//
//                        @Override
//                        public void onFailure(Call<Modalapi> call, Throwable t) {
//                            Log.e("Message" , t +"");
//                            Toast.makeText(MainActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//
//            }
//        });

    }

    private void listingData() {

        Method restApi = GlobalRetro.initRetrofit1(MainActivity.this);
            Call<MyPojo> listingData = restApi.getUserData("0");
            listingData.enqueue(new Callback<MyPojo>() {
                @Override
                public void onResponse(Call<MyPojo> call, Response<MyPojo> response) {
                        Log.d("data", String.valueOf(response.body()));

                    ArrayList<Data> userList =  new ArrayList<>();

                    userList = response.body().getData();
                      RecyclerView.Adapter adapter = new ApiAdapter(MainActivity.this,userList);
                    recyclerview.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<MyPojo> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                }
            });
    }
}