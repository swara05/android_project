package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class SystemInfo extends AppCompatActivity {

    private TabLayout tab_layout;
    private ViewPager view_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);

        tab_layout = findViewById(R.id.tab_layout);
        view_page = findViewById(R.id.view_page);


        tab_layout.setupWithViewPager(view_page);
        RPAdapter rpAdapter = new RPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        rpAdapter.addFragment(new Sys1(), "System Info 1");
        rpAdapter.addFragment(new Sys2(), "System Info 2");


        view_page.setAdapter(rpAdapter);
    }
}