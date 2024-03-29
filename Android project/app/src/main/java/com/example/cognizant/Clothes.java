package com.example.cognizant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clothes extends AppCompatActivity {

    RecyclerView recyclerView;
    ClothAdapter clothAdapter;
    List<ModalCloth> userList;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);

      initData();
      initRecyclerView();

    }

    private void initData() {
        userList = new ArrayList<>();

        userList.add(new ModalCloth("T-shirt",R.drawable.tshirt));
        userList.add(new ModalCloth("Shirt",R.drawable.shirt));
        userList.add(new ModalCloth("Jeans",R.drawable.jeans));
        userList.add(new ModalCloth("Kurti",R.drawable.kurti));
        userList.add(new ModalCloth("Traditional Wear",R.drawable.traditional));
        userList.add(new ModalCloth("Western Wear",R.drawable.western));
    }
    private void initRecyclerView() {

        recyclerView=findViewById(R.id.recycleview);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        clothAdapter = new ClothAdapter(userList,getApplicationContext());
        recyclerView.setAdapter(clothAdapter);
        clothAdapter.notifyDataSetChanged();

    }
}