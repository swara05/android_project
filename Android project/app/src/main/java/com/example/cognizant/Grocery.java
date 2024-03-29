package com.example.cognizant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Grocery extends AppCompatActivity {

    RecyclerView recyclerView1;
    GroAdapter groAdapter;
    List<ModalGrocery> userList1;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

        initData();
        initRecyclerView();

    }

    private void initData() {
        userList1 = new ArrayList<>();

        userList1.add(new ModalGrocery(R.drawable.grocery,"Vegetable"));
        userList1.add(new ModalGrocery(R.drawable.dairy,"Dairy Products"));
        userList1.add(new ModalGrocery(R.drawable.oil,"Oil"));
        userList1.add(new ModalGrocery(R.drawable.cosmetics,"Cosmetic"));
        userList1.add(new ModalGrocery(R.drawable.beverages,"Beverage"));
        userList1.add(new ModalGrocery(R.drawable.flour,"Flour"));
        userList1.add(new ModalGrocery(R.drawable.babyproducts,"Baby Products"));

    }
    private void initRecyclerView() {

        recyclerView1=findViewById(R.id.recycleview1);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView1.setLayoutManager(linearLayoutManager);
        groAdapter = new GroAdapter(userList1,getApplicationContext());
        recyclerView1.setAdapter(groAdapter);
        groAdapter.notifyDataSetChanged();

    }
}