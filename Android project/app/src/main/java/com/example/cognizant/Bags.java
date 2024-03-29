package com.example.cognizant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Bags extends AppCompatActivity {

    RecyclerView recyclerView2;
    BagAdapter bagAdapter;
    List<ModalBag> userList2;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bags);

        initData();
        initRecyclerView();
    }

    private void initData() {
        userList2 = new ArrayList<>();
        userList2.add(new ModalBag(R.drawable.wallet,"Wallet"));
        userList2.add(new ModalBag(R.drawable.schoolbag,"School Bag"));
        userList2.add(new ModalBag(R.drawable.purse,"Purse"));
        userList2.add(new ModalBag(R.drawable.picnicbag,"Picnic Bag"));
        userList2.add(new ModalBag(R.drawable.trolleybag,"Trolley Bag"));
    }
    private void initRecyclerView() {
        recyclerView2 = findViewById(R.id.recycleview2);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager);
        bagAdapter = new BagAdapter(userList2,getApplicationContext());
        recyclerView2.setAdapter(bagAdapter);
        bagAdapter.notifyDataSetChanged();
    }
}