package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SIMDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView back;
    USSDAdapter ussdAdapter;
    List<ModalUSSD> userList;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simdetails);

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

        String e = getIntent().getStringExtra("card");

        if(e.equals("airtel")){
            userList.add(new ModalUSSD("How to Recharge","*120*(16 digits code)#"));
            userList.add(new ModalUSSD("Main Balance Enquiry","*123#"));
            userList.add(new ModalUSSD("Message Balance Enquiry","*555#"));
            userList.add(new ModalUSSD("Net Balance Enquiry","*123*10# / *123*11#"));
            userList.add(new ModalUSSD("How to Know your Number","*121*9#"));
            userList.add(new ModalUSSD("Custom care Number","121"));
        }else if(e.equals("aircel")){
            userList.add(new ModalUSSD("How to Recharge","*124*(16 digits code)#"));
            userList.add(new ModalUSSD("Main Balance Enquiry","*125#"));
            userList.add(new ModalUSSD("Message Balance Enquiry","*111*5# and *111*12#"));
            userList.add(new ModalUSSD("Net Balance Enquiry","*123*1#"));
            userList.add(new ModalUSSD("How to Know your Number","*1#"));
            userList.add(new ModalUSSD("Custom care Number","121 or 198"));
        }
        else if(e.equals("idea")){
            userList.add(new ModalUSSD("How to Recharge","*124*(16 digits code)#"));
            userList.add(new ModalUSSD("Main Balance Enquiry","*111#"));
            userList.add(new ModalUSSD("Message Balance Enquiry","*167*3#"));
            userList.add(new ModalUSSD("Net Balance Enquiry","*125#"));
            userList.add(new ModalUSSD("How to Know your Number","*1#"));
            userList.add(new ModalUSSD("Custom care Number","12345"));
        }else if(e.equals("vodafone")){
            userList.add(new ModalUSSD("How to Recharge","*140*(16 digits code)#"));
            userList.add(new ModalUSSD("Main Balance Enquiry","*145# or *146#"));
            userList.add(new ModalUSSD("Message Balance Enquiry","*142#"));
            userList.add(new ModalUSSD("Net Balance Enquiry","*111*6# or *111*6*2#"));
            userList.add(new ModalUSSD("How to Know your Number","*111*2#"));
            userList.add(new ModalUSSD("Custom care Number","121 or 9885098850"));
        }else if(e.equals("jio")){
            userList.add(new ModalUSSD("How to Recharge","*123*(16 digits code)#"));
            userList.add(new ModalUSSD("Main Balance Enquiry","*123#"));
            userList.add(new ModalUSSD("Message Balance Enquiry","*112# then press 3"));
            userList.add(new ModalUSSD("Net Balance Enquiry","*112# then press 2"));
            userList.add(new ModalUSSD("How to Know your Number","*1#"));
            userList.add(new ModalUSSD("Custom care Number","1503"));
        }else if(e.equals("bsnl")){
            userList.add(new ModalUSSD("How to Recharge","*368*(16 digits code)#"));
            userList.add(new ModalUSSD("Main Balance Enquiry","*367#"));
            userList.add(new ModalUSSD("Message Balance Enquiry","*555#"));
            userList.add(new ModalUSSD("Net Balance Enquiry","*367*3#"));
            userList.add(new ModalUSSD("How to Know your Number","*1#"));
            userList.add(new ModalUSSD("Custom care Number","*333"));
        }else if(e.equals("docomo")){
            userList.add(new ModalUSSD("How to Recharge","*135*2*(16 digits code)#"));
            userList.add(new ModalUSSD("Main Balance Enquiry","*111#"));
            userList.add(new ModalUSSD("Message Balance Enquiry","*111*1#"));
            userList.add(new ModalUSSD("Net Balance Enquiry","*123*1#"));
            userList.add(new ModalUSSD("How to Know your Number","*580#"));
            userList.add(new ModalUSSD("Custom care Number","121"));
        }else if(e.equals("uninor")){
            userList.add(new ModalUSSD("How to Recharge","*222*3*(16 digits code)#"));
            userList.add(new ModalUSSD("Main Balance Enquiry","*222*2#"));
            userList.add(new ModalUSSD("Message Balance Enquiry","*222*2#"));
            userList.add(new ModalUSSD("Net Balance Enquiry","*123#"));
            userList.add(new ModalUSSD("How to Know your Number","*1#"));
            userList.add(new ModalUSSD("Custom care Number","121 or 9059090590"));
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