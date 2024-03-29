package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class USSDDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView back;
    USSDAdapter ussdAdapter;
    List<ModalUSSD> userList;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ussddetails);

        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.recyclerView);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initData();
        initRecyclerView();
    }
    private void initData() {
        userList = new ArrayList<>();

        String e = getIntent().getStringExtra("sim");

        if(e.equals("airtel")){
            userList.add(new ModalUSSD("Main Balance","*123#"));
            userList.add(new ModalUSSD("APN","airtelgprs.com"));
            userList.add(new ModalUSSD("2G Data Balance","*123*10#"));
            userList.add(new ModalUSSD("3G Data Balance","*123*11#"));
            userList.add(new ModalUSSD("Customer Care","198(Toll Free)"));
            userList.add(new ModalUSSD("Check your number","*282#"));
            userList.add(new ModalUSSD("Check own number","*121*9#"));
            userList.add(new ModalUSSD("Balance & Validity of Plans","*129*08#"));
            userList.add(new ModalUSSD("Data offers","*567#"));
            userList.add(new ModalUSSD("Deactivate VAS","SMS STOP to 155223"));
        }else if(e.equals("idea")){
            userList.add(new ModalUSSD("Main Balance","*121#"));
            userList.add(new ModalUSSD("Customer Care","198(Toll Free)"));
            userList.add(new ModalUSSD("APN","internet"));
            userList.add(new ModalUSSD("Data Balance","*125# / *656#"));
            userList.add(new ModalUSSD("Night Packs","*121*9#"));
            userList.add(new ModalUSSD("Deactivate VAS","SMS STOP to 155223"));
        }else if(e.equals("vodafone")){
            userList.add(new ModalUSSD("Customer Care","198"));
            userList.add(new ModalUSSD("Main Balance","*141#"));
            userList.add(new ModalUSSD("Special offers","*121#"));
            userList.add(new ModalUSSD("VAS","*123#"));
            userList.add(new ModalUSSD("Data Balance","*111*6*2#"));
            userList.add(new ModalUSSD("LAST 3 ACTIVITIES","*111*3#"));
            userList.add(new ModalUSSD("Best offers","*111*8#"));
            userList.add(new ModalUSSD("Check own number","*131*0#"));
          userList.add(new ModalUSSD("Deactivate VAS","SMS STOP to 155223"));
        }else if(e.equals("jio")){
            userList.add(new ModalUSSD("Complaints Helpline","198"));
            userList.add(new ModalUSSD("General Helpline","199"));
            userList.add(new ModalUSSD("Helpline","1800889999(toll free)"));
        }else if(e.equals("bsnl")){
            userList.add(new ModalUSSD("Main Balance","*123*1#"));
            userList.add(new ModalUSSD("APN","bsnlnet"));
            userList.add(new ModalUSSD("Customer Care","1503(Toll Free)"));
            userList.add(new ModalUSSD("Deactivate VAS","SMS STOP to 155223"));
        }else if(e.equals("docomo")){
            userList.add(new ModalUSSD("Main Balance","*111#"));
            userList.add(new ModalUSSD("Customer Care","198(Toll Free)"));
            userList.add(new ModalUSSD("Data Balance","*111*1#"));
            userList.add(new ModalUSSD("Emergency Talktime(Rs.4)","*369#"));
            userList.add(new ModalUSSD("Check own number","*1# or *580#"));
            userList.add(new ModalUSSD("LAST 3 recharges","*191*5#"));
            userList.add(new ModalUSSD("Special offers","*123#"));
            userList.add(new ModalUSSD("Balance","*111#"));
            userList.add(new ModalUSSD("Deactivate VAS","SMS STOP to 155223"));
        }else if(e.equals("uninor")){
            userList.add(new ModalUSSD("Main Balance & Validity","*363*4#"));
            userList.add(new ModalUSSD("Main Balance","*222*2#"));
            userList.add(new ModalUSSD("APN","telenor"));
            userList.add(new ModalUSSD("Check own number","*222*4#"));
            userList.add(new ModalUSSD("Check own number","*1#"));
            userList.add(new ModalUSSD("Customer care","198 (Toll Free)"));
        }


    }
    private void initRecyclerView() {

        recyclerView=findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ussdAdapter = new USSDAdapter(userList,getApplicationContext());
        recyclerView.setAdapter(ussdAdapter);
        ussdAdapter.notifyDataSetChanged();

    }
}