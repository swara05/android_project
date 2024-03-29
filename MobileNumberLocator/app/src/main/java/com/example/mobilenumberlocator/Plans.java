package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Plans extends AppCompatActivity {

    private TabLayout tab_layout;
    //TabItem topup,g4,g3,local,sms,std,isd,other;
    private ViewPager view_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);

        tab_layout = findViewById(R.id.tab_layout);
        view_page = findViewById(R.id.view_page);
//        topup = findViewById(R.id.topup);
//        g4 = findViewById(R.id.g4);
//        g3 = findViewById(R.id.g3);
//        local = findViewById(R.id.local);
//        sms = findViewById(R.id.sms);
//        std = findViewById(R.id.std);
//        isd = findViewById(R.id.isd);
//        other = findViewById(R.id.other);


        tab_layout.setupWithViewPager(view_page);
        RPAdapter rpAdapter = new RPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        rpAdapter.addFragment(new TopupFragment(),"Topup");
        rpAdapter.addFragment(new G4Fragment(),"4g");
        rpAdapter.addFragment(new G3Fragment(),"3g");
        rpAdapter.addFragment(new LocalFragment(),"Local");
        rpAdapter.addFragment(new SmsFragment(),"Sms");
        rpAdapter.addFragment(new StdFragment(),"Std");
        rpAdapter.addFragment(new IsdFragment(),"Isd");
        rpAdapter.addFragment(new OtherFragment(),"Other");

        view_page.setAdapter(rpAdapter);


    }
}