package com.example.mobilenumberlocator;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class TopupFragment extends Fragment {

    RecyclerView recyclerView;
    TopupAdapater topupAdapater;
    List<ModalTopup> userList;
    LinearLayoutManager linearLayoutManager;


    private void initData() {
        userList = new ArrayList<>();

        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("value1");
        String sname = intent.getStringExtra("value2");

        if (name.equals("Airtel")) {
            if (sname.equals("Assam") || sname.equals("Chennai") || sname.equals("Delhi NCR") || sname.equals("Gujarat") || sname.equals("Himachal Pradesh") || sname.equals("Jammu Kashmir")) {
                userList.add(new ModalTopup("10", "N/A", "N/A"));
                userList.add(new ModalTopup("20", "N/A", "N/A"));
                userList.add(new ModalTopup("100", "N/A", "N/A"));
                userList.add(new ModalTopup("199", "Enjoy unlimited Local,STD & Roaming calls on any network, Total 3GB Data, Rs.5 Talktime & 300 SMS | Valid for 30", "30 days"));
                userList.add(new ModalTopup("359", "Enjoy unlimited Local,STD & Roaming calls on any network, daily 2GB data, Rs.5 Talktime and 100 SMS | Pack", "1 month"));
                userList.add(new ModalTopup("500", "N/A", "N/A"));
                userList.add(new ModalTopup("1000", "N/A", "N/A"));
                userList.add(new ModalTopup("5000", "N/A", "N/A"));
            } else if (sname.equals("Bihar") || sname.equals("Hariyana")) {
                userList.add(new ModalTopup("", "", ""));
            }
        } else if (name.equals("Jio")) {
            if (sname.equals("Assam") || sname.equals("Chennai") || sname.equals("Delhi NCR") || sname.equals("Gujarat") || sname.equals("Himachal Pradesh") || sname.equals("Jammu Kashmir")) {
                userList.add(new ModalTopup("10", "N/A", "N/A"));
                userList.add(new ModalTopup("20", "N/A", "N/A"));
                userList.add(new ModalTopup("50", "N/A", "N/A"));
                userList.add(new ModalTopup("100", "N/A", "N/A"));
                userList.add(new ModalTopup("1000", "N/A", "N/A"));
            } else if (sname.equals("Bihar") || sname.equals("Hariyana")) {
                userList.add(new ModalTopup("", "", ""));
            }
        }
        else if (name.equals("Vodafone")) {
            if (sname.equals("Assam") || sname.equals("Chennai") || sname.equals("Delhi NCR") || sname.equals("Gujarat")) {
                userList.add(new ModalTopup("10", "Talktime: Rs.7.47 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("20", "Talktime: Rs.14.95 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("30", "Talktime: Rs.22.42 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("39", "2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.30.0", "14 days"));
                userList.add(new ModalTopup("49", "N/A", "28 days"));
                userList.add(new ModalTopup("50", "Talktime: Rs.39.37 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("79", "N/A", "28 days"));
                userList.add(new ModalTopup("95", "2G/3G/4G Data:200 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.74.0", "56 days"));
                userList.add(new ModalTopup("100", "Talktime: Rs.81.75 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("500", "Talktime: Rs.423.73 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("1000", "Talktime: Rs.847.46 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("5000", "Talktime: Rs.4237.29 | No Service Validity of 28 days", "N/A"));
            } else if (sname.equals("Bihar") || sname.equals("Hariyana") || sname.equals("Jammu Kashmir")) {
                userList.add(new ModalTopup("", "", ""));
            } else if (sname.equals("Himachal Pradesh")) {
                userList.add(new ModalTopup("10", "Talktime: Rs.7.47 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("20", "Talktime: Rs.14.95 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("30", "Talktime: Rs.22.42 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("49", "N/A", "28 days"));
                userList.add(new ModalTopup("50", "Talktime: Rs.39.37 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("79", "N/A", "28 days"));
                userList.add(new ModalTopup("95", "2G/3G/4G Data:200 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.74.0", "56 days"));
                userList.add(new ModalTopup("100", "Talktime: Rs.81.75 | No Service Validity of 28 days", "N/A"));
            }
        } else if (name.equals("Idea")) {
            if (sname.equals("Assam")) {
                userList.add(new ModalTopup("10", "Talktime: Rs.7.47 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("20", "Talktime: Rs.14.95 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("30", "Talktime: Rs.22.42 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("39", "2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.30.0", "14 days"));
                userList.add(new ModalTopup("49", "2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.38.0", "28 days"));
                userList.add(new ModalTopup("50", "Talktime: Rs.39.37 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("79", "2G/3G/4G Data:100 MB | Local & STD Calls @ 1.0 p/sec | Talktime: Rs.64.0", "28 days"));
                userList.add(new ModalTopup("95", "2G/3G/4G Data:200 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.74.0", "56 days"));
                userList.add(new ModalTopup("100", "Talktime: Rs.81.75 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("500", "Talktime: Rs.423.73 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("1000", "Talktime: Rs.847.46 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("5000", "Talktime: Rs.4237.29 | No Service Validity of 28 days", "N/A"));
            }else if( sname.equals("Delhi NCR")) {
                userList.add(new ModalTopup("10", "Talktime: Rs.7.47 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("20", "Talktime: Rs.14.95 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("29","2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.15.0","14 days"));
                userList.add(new ModalTopup("30", "Talktime: Rs.22.42 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("39", "2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.30.0", "14 days"));
                userList.add(new ModalTopup("49", "2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.38.0", "28 days"));
                 userList.add(new ModalTopup("79", "2G/3G/4G Data:100 MB | Local & STD Calls @ 1.0 p/sec | Talktime: Rs.64.0", "28 days"));
                userList.add(new ModalTopup("95", "2G/3G/4G Data:200 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.74.0", "56 days"));
                userList.add(new ModalTopup("100", "Talktime: Rs.81.75 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("500", "Talktime: Rs.423.73 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("1000", "Talktime: Rs.847.46 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("5000", "Talktime: Rs.4237.29 | No Service Validity of 28 days", "N/A"));
            }else if(sname.equals("Gujarat")) {
                userList.add(new ModalTopup("10", "Talktime: Rs.7.47 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("20", "Talktime: Rs.14.95 | No Service Validity", "N/A"));
                 userList.add(new ModalTopup("30", "Talktime: Rs.22.42 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("49", "2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.38.0", "28 days"));
                userList.add(new ModalTopup("50","Talktime: Rs.39.37 | No Service Validity","N/A"));
                userList.add(new ModalTopup("79", "2G/3G/4G Data:100 MB | Local & STD Calls @ 1.0 p/sec | Talktime: Rs.64.0", "28 days"));
                userList.add(new ModalTopup("95", "2G/3G/4G Data:200 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.74.0", "56 days"));
                userList.add(new ModalTopup("100", "Talktime: Rs.81.75 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("500", "Talktime: Rs.423.73 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("1000", "Talktime: Rs.847.46 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("5000", "Talktime: Rs.4237.29 | No Service Validity of 28 days", "N/A"));
            }else if(sname.equals("Himachal Pradesh")){
                userList.add(new ModalTopup("10", "Talktime: Rs.7.47 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("20", "Talktime: Rs.14.95 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("30", "Talktime: Rs.22.42 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("49", "2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.38.0", "28 days"));
                userList.add(new ModalTopup("50","Talktime: Rs.39.37 | No Service Validity","N/A"));
                userList.add(new ModalTopup("79", "2G/3G/4G Data:100 MB | Local & STD Calls @ 1.0 p/sec | Talktime: Rs.64.0", "28 days"));
                userList.add(new ModalTopup("95", "2G/3G/4G Data:200 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.74.0", "56 days"));
               userList.add(new ModalTopup("97","2G/3G/4G Data:100 MB | Local, STD & Roaming Calls @1.0 p/sec | Talktime: Rs.45.0","28 days"));
                userList.add(new ModalTopup("100", "Talktime: Rs.81.75 | No Service Validity of 28 days", "N/A"));
            }
            else if (sname.equals("Bihar") || sname.equals("Hariyana")) {
                userList.add(new ModalTopup("", "", ""));
            }else if(sname.equals("Chennai")){
                userList.add(new ModalTopup("10", "Talktime: Rs.7.47 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("20", "Talktime: Rs.14.95 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("30", "Talktime: Rs.22.42 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("49", "2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.38.0", "28 days"));
                userList.add(new ModalTopup("50", "Talktime: Rs.39.37 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("79", "2G/3G/4G Data:100 MB | Local & STD Calls @ 1.0 p/sec | Talktime: Rs.64.0", "28 days"));
                userList.add(new ModalTopup("95", "2G/3G/4G Data:200 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.74.0", "56 days"));
                userList.add(new ModalTopup("100", "Talktime: Rs.81.75 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("500", "Talktime: Rs.423.73 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("1000", "Talktime: Rs.847.46 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("5000", "Talktime: Rs.4237.29 | No Service Validity of 28 days", "N/A"));
            }else if(sname.equals("Jammu Kashmir")){
                userList.add(new ModalTopup("10", "Talktime: Rs.7.47 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("20", "Talktime: Rs.14.95 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("30", "Talktime: Rs.22.42 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("39", "2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.30.0", "14 days"));
                userList.add(new ModalTopup("49", "2G/3G/4G Data:100 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.38.0", "28 days"));
                userList.add(new ModalTopup("50", "Talktime: Rs.39.37 | No Service Validity", "N/A"));
                userList.add(new ModalTopup("79", "2G/3G/4G Data:100 MB | Local & STD Calls @ 1.0 p/sec | Talktime: Rs.64.0", "28 days"));
                userList.add(new ModalTopup("95", "2G/3G/4G Data:200 MB | Local & STD Calls @ 2.5 p/sec | Talktime: Rs.74.0", "56 days"));
                userList.add(new ModalTopup("97","2G/3G/4G Data:100 MB | Local, STD & Roaming Calls @1.0 p/sec | Talktime: Rs.45.0","28 days"));
                userList.add(new ModalTopup("100", "Talktime: Rs.81.75 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("500", "Talktime: Rs.423.73 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("1000", "Talktime: Rs.847.46 | No Service Validity of 28 days", "N/A"));
                userList.add(new ModalTopup("5000", "Talktime: Rs.4237.29 | No Service Validity of 28 days", "N/A"));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topup, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();

        recyclerView = getView().findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        topupAdapater = new TopupAdapater(userList,getContext());
        recyclerView.setAdapter(topupAdapater);
        topupAdapater.notifyDataSetChanged();


    }
}