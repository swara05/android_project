package com.example.mobilenumberlocator;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class DeviceInfo extends AppCompatActivity {

    private TabLayout tab_layout;
    private ViewPager view_page;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);

        tab_layout = findViewById(R.id.tab_layout);
        view_page = findViewById(R.id.view_page);
back = findViewById(R.id.back);

back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        onBackPressed();
    }
});

        tab_layout.setupWithViewPager(view_page);
        RPAdapter rpAdapter = new RPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        rpAdapter.addFragment(new Info1(), "Device Info 1");
        rpAdapter.addFragment(new Info2(), "Device Info 2");


        view_page.setAdapter(rpAdapter);
    }
}