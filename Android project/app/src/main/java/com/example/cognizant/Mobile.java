package com.example.cognizant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Mobile extends AppCompatActivity {

    RecyclerView recyclerView3;
    LinearLayoutManager linearLayoutManager;
    List<ModalMobile> userList3;
    MobileAdapter mobileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);

        initData();
        initRecyclerView();
    }

    private void initData(){
        userList3 = new ArrayList<>();
        userList3.add(new ModalMobile(R.drawable.apple,"Apple"));
        userList3.add(new ModalMobile(R.drawable.oneplus,"One Plus"));
        userList3.add(new ModalMobile(R.drawable.samsung,"Samsung"));
        userList3.add(new ModalMobile(R.drawable.vivo,"Vivo"));
        userList3.add(new ModalMobile(R.drawable.oppo,"Oppo"));

    }
    private void initRecyclerView() {
        recyclerView3 = findViewById(R.id.recycleview3);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView3.setLayoutManager(linearLayoutManager);
        mobileAdapter = new MobileAdapter(userList3,getApplicationContext());
        recyclerView3.setAdapter(mobileAdapter);
        mobileAdapter.notifyDataSetChanged();
    }
}