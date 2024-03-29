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


public class LocalFragment extends Fragment {
    RecyclerView recycler;
    LocalAdapter localAdapter;
    List<ModalTopup> userList;
    LinearLayoutManager linearLayoutManager;


    private void initData() {
        userList = new ArrayList<>();

        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("value1");
        String sname = intent.getStringExtra("value2");


        if(name.equals("Airtel")){
            if(sname.equals("Assam")  || sname.equals("Chennai") || sname.equals("Delhi NCR")||sname.equals("Gujarat")||sname.equals("Himachal Pradesh")||sname.equals("Hariyana")||sname.equals("Jammu Kashmir")){
                //        userList.add(new ModalTopup("19","Data: 1GB | Validity: 1 Day","1 day"));
//        userList.add(new ModalTopup("29","Data: 2GB | Validity: 1 Day(till midnight)Only for customers with active validity","1 day"));
//        userList.add(new ModalTopup("58","3 GB Data | Validity same as your existing bundle/smart pack","N/A"));
//        userList.add(new ModalTopup("65","4 GB Data | Validity same as your existing bundle/smart pack","N/A"));
//        userList.add(new ModalTopup("98","Data: 5 GB Wynk Music Premium subscription | Validity: Same as your existing pack ❘ Pack Applicable for active validity","N/A"));
//        userList.add(new ModalTopup("118","12 GB Data | Validity same as your existing bundle /smart pack","N/A"));
//        userList.add(new ModalTopup("148","Xstream Mobile Data Pack: 15GB Data | Additional Benefits: Xstream App (Watch Shark Tank 2)28 days","N/A"));
//        userList.add(new ModalTopup("149","1 GB data, validity as per current pack,Xstream Premium for 1 Month: Get 15+ OTTS in 1 App : SonyLiv, Eros","N/A"));
                userList.add(new ModalTopup("155","Enjoy Unlimited Local, STD & Roaming calls Local STD & Roaming calls on any network 1GB data & 300","24 days"));
                userList.add(new ModalTopup("179","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data, 300 National SMS for 28 days","28 days"));
                // userList.add(new ModalTopup("181","Data: 1GB/day; Validity: 30 DAYS 30 days","30 days"));
                userList.add(new ModalTopup("199","Enjoy unlimited Local, STD & Roaming calls on any network, Total 3GB Data, Rs.5 Talktime & 300 SMS | Valid for 30","30 days"));
                userList.add(new ModalTopup("209","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, daily 1GB data and 100 SMS ","21 days"));
                userList.add(new ModalTopup("239","Enjoy unlimited Local, STD & Roaming calls on any network, 1GB/day data and 100 SMS | Pack valid for 24 days","24 days"));
                userList.add(new ModalTopup("265","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1 GB data per day, 100 National SMS/day","28 days"));
                userList.add(new ModalTopup("296","Enjoy unlimited Local, STD & Roaming calls on any network, 25GB Data and 100 SMS/day|Claim UNLIMITED","30 days"));
                userList.add(new ModalTopup("299","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/ ","28 days"));
                // userList.add(new ModalTopup("301","Enjoy 50 GB and 1year of Wynk Music Premium subscription | Validity same as your existing bundle /smart pack","N/A"));
                userList.add(new ModalTopup("319","Enjoy unlimited Local, STD & Roaming calls on any network, 2GB/day Data and 100 SMS/day,Validity: 1 Month","1 month"));
                userList.add(new ModalTopup("359","Enjoy unlimited Local, STD & Roaming calls on any network, daily 2GB data, Rs.5 Talktime and 100 SMS | Pack","1 month"));
                userList.add(new ModalTopup("399","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2.5GB data per day, 100 National SMS/day","28 days"));
                userList.add(new ModalTopup("455","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 6GB data, 900 National SMS for 84","84 days"));
                userList.add(new ModalTopup("479","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/day","56 days"));
                userList.add(new ModalTopup("489","Enjoy unlimited Local, STD & Roaming calls on any network, Total 50GB Data & 300 SMS|Apollo 24|7 Circle","30 days"));
                userList.add(new ModalTopup("499","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 3 GB data per day, 100 National SMS/day","28 days"));
                userList.add(new ModalTopup("509","Enjoy unlimited Local, STD & Roaming calls on any network, Total 60GB Data & 300 SMS Valid for 1 month","1 month"));
                userList.add(new ModalTopup("519","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Apollo 24|7 Circle","60 days"));
                userList.add(new ModalTopup("549","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data per day, 100 National SMS/day","56 days"));
                userList.add(new ModalTopup("666","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Apollo 24|7 Circle","77 days"));
                userList.add(new ModalTopup("699","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 3 GB data per day, 100 National SMS","56 days"));
                userList.add(new ModalTopup("719","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/day","84 days"));
                userList.add(new ModalTopup("779","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Claim UNLIMITED","90 days"));
                userList.add(new ModalTopup("839","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data per day, 100 National SMS/day","84 days"));
                userList.add(new ModalTopup("999","Enjoy unlimited Local, STD & Roaming calls on any network, 2.5GB/day data and 100 SMS/day and Claim ","84 days"));
                userList.add(new ModalTopup("1799","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 24GB data, 3600 National SMS for 365 days","1 year"));
                userList.add(new ModalTopup("2999","Enjoy Truly unlimited Local, STD & Roaming calls on any network within India, daily 2GB data & 100 SMS, ","1 year"));
                userList.add(new ModalTopup("3359","Enjoy unlimited Local, STD & Roaming calls on any network, daily 2.5GB & 100 SMS | Pack Valid for 365 days","1 year"));
            }else if(sname.equals("Bihar")){
                userList.add(new ModalTopup("","",""));
            }
        }
        if(name.equals("Jio")){
            if(sname.equals("Assam")  || sname.equals("Chennai") || sname.equals("Delhi NCR")||sname.equals("Gujarat")||sname.equals("Jammu Kashmir")){
                //        userList.add(new ModalTopup("19","Data: 1GB | Validity: 1 Day","1 day"));
//        userList.add(new ModalTopup("29","Data: 2GB | Validity: 1 Day(till midnight)Only for customers with active validity","1 day"));
//        userList.add(new ModalTopup("58","3 GB Data | Validity same as your existing bundle/smart pack","N/A"));
//        userList.add(new ModalTopup("65","4 GB Data | Validity same as your existing bundle/smart pack","N/A"));
//        userList.add(new ModalTopup("98","Data: 5 GB Wynk Music Premium subscription | Validity: Same as your existing pack ❘ Pack Applicable for active validity","N/A"));
//        userList.add(new ModalTopup("118","12 GB Data | Validity same as your existing bundle /smart pack","N/A"));
//        userList.add(new ModalTopup("148","Xstream Mobile Data Pack: 15GB Data | Additional Benefits: Xstream App (Watch Shark Tank 2)28 days","N/A"));
//        userList.add(new ModalTopup("149","1 GB data, validity as per current pack,Xstream Premium for 1 Month: Get 15+ OTTS in 1 App : SonyLiv, Eros","N/A"));
                userList.add(new ModalTopup("155","Enjoy Unlimited Local, STD & Roaming calls Local STD & Roaming calls on any network 1GB data & 300","24 days"));
                userList.add(new ModalTopup("179","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data, 300 National SMS for 28 days","28 days"));
                // userList.add(new ModalTopup("181","Data: 1GB/day; Validity: 30 DAYS 30 days","30 days"));
                userList.add(new ModalTopup("199","Enjoy unlimited Local, STD & Roaming calls on any network, Total 3GB Data, Rs.5 Talktime & 300 SMS | Valid for 30","30 days"));
                userList.add(new ModalTopup("209","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, daily 1GB data and 100 SMS ","21 days"));
                userList.add(new ModalTopup("239","Enjoy unlimited Local, STD & Roaming calls on any network, 1GB/day data and 100 SMS | Pack valid for 24 days","24 days"));
                userList.add(new ModalTopup("265","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1 GB data per day, 100 National SMS/day","28 days"));
                userList.add(new ModalTopup("296","Enjoy unlimited Local, STD & Roaming calls on any network, 25GB Data and 100 SMS/day|Claim UNLIMITED","30 days"));
                userList.add(new ModalTopup("299","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/ ","28 days"));
                // userList.add(new ModalTopup("301","Enjoy 50 GB and 1year of Wynk Music Premium subscription | Validity same as your existing bundle /smart pack","N/A"));
                userList.add(new ModalTopup("319","Enjoy unlimited Local, STD & Roaming calls on any network, 2GB/day Data and 100 SMS/day,Validity: 1 Month","1 month"));
                userList.add(new ModalTopup("359","Enjoy unlimited Local, STD & Roaming calls on any network, daily 2GB data, Rs.5 Talktime and 100 SMS | Pack","1 month"));
                userList.add(new ModalTopup("399","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2.5GB data per day, 100 National SMS/day","28 days"));
                userList.add(new ModalTopup("455","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 6GB data, 900 National SMS for 84","84 days"));
                userList.add(new ModalTopup("479","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/day","56 days"));
                userList.add(new ModalTopup("489","Enjoy unlimited Local, STD & Roaming calls on any network, Total 50GB Data & 300 SMS|Apollo 24|7 Circle","30 days"));
//                userList.add(new ModalTopup("499","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 3 GB data per day, 100 National SMS/day","28 days"));
//                userList.add(new ModalTopup("509","Enjoy unlimited Local, STD & Roaming calls on any network, Total 60GB Data & 300 SMS Valid for 1 month","1 month"));
//                userList.add(new ModalTopup("519","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Apollo 24|7 Circle","60 days"));
                userList.add(new ModalTopup("549","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data per day, 100 National SMS/day","56 days"));
                userList.add(new ModalTopup("666","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Apollo 24|7 Circle","77 days"));
                userList.add(new ModalTopup("699","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 3 GB data per day, 100 National SMS","56 days"));
                userList.add(new ModalTopup("719","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/day","84 days"));
                userList.add(new ModalTopup("779","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Claim UNLIMITED","90 days"));
                userList.add(new ModalTopup("839","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data per day, 100 National SMS/day","84 days"));
                userList.add(new ModalTopup("999","Enjoy unlimited Local, STD & Roaming calls on any network, 2.5GB/day data and 100 SMS/day and Claim ","84 days"));
                userList.add(new ModalTopup("1799","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 24GB data, 3600 National SMS for 365 days","1 year"));
                userList.add(new ModalTopup("2999","Enjoy Truly unlimited Local, STD & Roaming calls on any network within India, daily 2GB data & 100 SMS, ","1 year"));
               // userList.add(new ModalTopup("3359","Enjoy unlimited Local, STD & Roaming calls on any network, daily 2.5GB & 100 SMS | Pack Valid for 365 days","1 year"));
            }else if(sname.equals("Bihar") ||sname.equals("Himachal Pradesh")||sname.equals("Hariyana")){
                userList.add(new ModalTopup("","",""));
            }
        }
        if(name.equals("Vodafone")){
            if(sname.equals("Assam")  || sname.equals("Chennai") || sname.equals("Delhi NCR")||sname.equals("Gujarat")||sname.equals("Himachal Pradesh")||sname.equals("Jammu Kashmir")){
                        userList.add(new ModalTopup("19","Data: 1GB | Validity: 1 Day","1 day"));
        userList.add(new ModalTopup("29","Data: 2GB | Validity: 1 Day(till midnight)Only for customers with active validity","1 day"));
        userList.add(new ModalTopup("58","3 GB Data | Validity same as your existing bundle/smart pack","N/A"));
//        userList.add(new ModalTopup("65","4 GB Data | Validity same as your existing bundle/smart pack","N/A"));
//        userList.add(new ModalTopup("98","Data: 5 GB Wynk Music Premium subscription | Validity: Same as your existing pack ❘ Pack Applicable for active validity","N/A"));
//        userList.add(new ModalTopup("118","12 GB Data | Validity same as your existing bundle /smart pack","N/A"));
//        userList.add(new ModalTopup("148","Xstream Mobile Data Pack: 15GB Data | Additional Benefits: Xstream App (Watch Shark Tank 2)28 days","N/A"));
//        userList.add(new ModalTopup("149","1 GB data, validity as per current pack,Xstream Premium for 1 Month: Get 15+ OTTS in 1 App : SonyLiv, Eros","N/A"));
                userList.add(new ModalTopup("155","Enjoy Unlimited Local, STD & Roaming calls Local STD & Roaming calls on any network 1GB data & 300","24 days"));
                userList.add(new ModalTopup("179","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data, 300 National SMS for 28 days","28 days"));
                // userList.add(new ModalTopup("181","Data: 1GB/day; Validity: 30 DAYS 30 days","30 days"));
                userList.add(new ModalTopup("199","Enjoy unlimited Local, STD & Roaming calls on any network, Total 3GB Data, Rs.5 Talktime & 300 SMS | Valid for 30","30 days"));
                userList.add(new ModalTopup("209","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, daily 1GB data and 100 SMS ","21 days"));
                userList.add(new ModalTopup("239","Enjoy unlimited Local, STD & Roaming calls on any network, 1GB/day data and 100 SMS | Pack valid for 24 days","24 days"));
                userList.add(new ModalTopup("265","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1 GB data per day, 100 National SMS/day","28 days"));
                userList.add(new ModalTopup("296","Enjoy unlimited Local, STD & Roaming calls on any network, 25GB Data and 100 SMS/day|Claim UNLIMITED","30 days"));
                userList.add(new ModalTopup("299","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/ ","28 days"));
                // userList.add(new ModalTopup("301","Enjoy 50 GB and 1year of Wynk Music Premium subscription | Validity same as your existing bundle /smart pack","N/A"));
                userList.add(new ModalTopup("319","Enjoy unlimited Local, STD & Roaming calls on any network, 2GB/day Data and 100 SMS/day,Validity: 1 Month","1 month"));
                userList.add(new ModalTopup("359","Enjoy unlimited Local, STD & Roaming calls on any network, daily 2GB data, Rs.5 Talktime and 100 SMS | Pack","1 month"));
                userList.add(new ModalTopup("399","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2.5GB data per day, 100 National SMS/day","28 days"));
                userList.add(new ModalTopup("455","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 6GB data, 900 National SMS for 84","84 days"));
                userList.add(new ModalTopup("479","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/day","56 days"));
                userList.add(new ModalTopup("489","Enjoy unlimited Local, STD & Roaming calls on any network, Total 50GB Data & 300 SMS|Apollo 24|7 Circle","30 days"));
                userList.add(new ModalTopup("499","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 3 GB data per day, 100 National SMS/day","28 days"));
                userList.add(new ModalTopup("509","Enjoy unlimited Local, STD & Roaming calls on any network, Total 60GB Data & 300 SMS Valid for 1 month","1 month"));
                userList.add(new ModalTopup("519","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Apollo 24|7 Circle","60 days"));
                userList.add(new ModalTopup("549","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data per day, 100 National SMS/day","56 days"));
                userList.add(new ModalTopup("666","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Apollo 24|7 Circle","77 days"));
                userList.add(new ModalTopup("699","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 3 GB data per day, 100 National SMS","56 days"));
                userList.add(new ModalTopup("719","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/day","84 days"));
                userList.add(new ModalTopup("779","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Claim UNLIMITED","90 days"));
                userList.add(new ModalTopup("839","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data per day, 100 National SMS/day","84 days"));
                userList.add(new ModalTopup("999","Enjoy unlimited Local, STD & Roaming calls on any network, 2.5GB/day data and 100 SMS/day and Claim ","84 days"));
//                userList.add(new ModalTopup("1799","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 24GB data, 3600 National SMS for 365 days","1 year"));
//                userList.add(new ModalTopup("2999","Enjoy Truly unlimited Local, STD & Roaming calls on any network within India, daily 2GB data & 100 SMS, ","1 year"));
//                userList.add(new ModalTopup("3359","Enjoy unlimited Local, STD & Roaming calls on any network, daily 2.5GB & 100 SMS | Pack Valid for 365 days","1 year"));
            }else if(sname.equals("Bihar")||sname.equals("Hariyana")){
                userList.add(new ModalTopup("","",""));
            }
        }
        if(name.equals("Idea")){
            if(sname.equals("Assam")  || sname.equals("Chennai") || sname.equals("Delhi NCR")||sname.equals("Gujarat")){
                        userList.add(new ModalTopup("19","Data: 1GB | Validity: 1 Day","1 day"));
        userList.add(new ModalTopup("29","Data: 2GB | Validity: 1 Day(till midnight)Only for customers with active validity","1 day"));
        userList.add(new ModalTopup("58","3 GB Data | Validity same as your existing bundle/smart pack","N/A"));
        userList.add(new ModalTopup("65","4 GB Data | Validity same as your existing bundle/smart pack","N/A"));
//        userList.add(new ModalTopup("98","Data: 5 GB Wynk Music Premium subscription | Validity: Same as your existing pack ❘ Pack Applicable for active validity","N/A"));
//        userList.add(new ModalTopup("118","12 GB Data | Validity same as your existing bundle /smart pack","N/A"));
//        userList.add(new ModalTopup("148","Xstream Mobile Data Pack: 15GB Data | Additional Benefits: Xstream App (Watch Shark Tank 2)28 days","N/A"));
//        userList.add(new ModalTopup("149","1 GB data, validity as per current pack,Xstream Premium for 1 Month: Get 15+ OTTS in 1 App : SonyLiv, Eros","N/A"));
                userList.add(new ModalTopup("155","Enjoy Unlimited Local, STD & Roaming calls Local STD & Roaming calls on any network 1GB data & 300","24 days"));
                userList.add(new ModalTopup("179","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data, 300 National SMS for 28 days","28 days"));
                // userList.add(new ModalTopup("181","Data: 1GB/day; Validity: 30 DAYS 30 days","30 days"));
                userList.add(new ModalTopup("199","Enjoy unlimited Local, STD & Roaming calls on any network, Total 3GB Data, Rs.5 Talktime & 300 SMS | Valid for 30","30 days"));
                userList.add(new ModalTopup("209","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, daily 1GB data and 100 SMS ","21 days"));
                userList.add(new ModalTopup("239","Enjoy unlimited Local, STD & Roaming calls on any network, 1GB/day data and 100 SMS | Pack valid for 24 days","24 days"));
                userList.add(new ModalTopup("265","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1 GB data per day, 100 National SMS/day","28 days"));
                userList.add(new ModalTopup("296","Enjoy unlimited Local, STD & Roaming calls on any network, 25GB Data and 100 SMS/day|Claim UNLIMITED","30 days"));
                userList.add(new ModalTopup("299","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/ ","28 days"));
                // userList.add(new ModalTopup("301","Enjoy 50 GB and 1year of Wynk Music Premium subscription | Validity same as your existing bundle /smart pack","N/A"));
                userList.add(new ModalTopup("319","Enjoy unlimited Local, STD & Roaming calls on any network, 2GB/day Data and 100 SMS/day,Validity: 1 Month","1 month"));
                userList.add(new ModalTopup("359","Enjoy unlimited Local, STD & Roaming calls on any network, daily 2GB data, Rs.5 Talktime and 100 SMS | Pack","1 month"));
                userList.add(new ModalTopup("399","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2.5GB data per day, 100 National SMS/day","28 days"));
                userList.add(new ModalTopup("455","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 6GB data, 900 National SMS for 84","84 days"));
                userList.add(new ModalTopup("479","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/day","56 days"));
                userList.add(new ModalTopup("489","Enjoy unlimited Local, STD & Roaming calls on any network, Total 50GB Data & 300 SMS|Apollo 24|7 Circle","30 days"));
//                userList.add(new ModalTopup("499","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 3 GB data per day, 100 National SMS/day","28 days"));
//                userList.add(new ModalTopup("509","Enjoy unlimited Local, STD & Roaming calls on any network, Total 60GB Data & 300 SMS Valid for 1 month","1 month"));
//                userList.add(new ModalTopup("519","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Apollo 24|7 Circle","60 days"));
                userList.add(new ModalTopup("549","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data per day, 100 National SMS/day","56 days"));
                userList.add(new ModalTopup("666","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Apollo 24|7 Circle","77 days"));
                userList.add(new ModalTopup("699","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 3 GB data per day, 100 National SMS","56 days"));
                userList.add(new ModalTopup("719","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/day","84 days"));
                userList.add(new ModalTopup("779","Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Claim UNLIMITED","90 days"));
                userList.add(new ModalTopup("839","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data per day, 100 National SMS/day","84 days"));
                userList.add(new ModalTopup("999","Enjoy unlimited Local, STD & Roaming calls on any network, 2.5GB/day data and 100 SMS/day and Claim ","84 days"));
                userList.add(new ModalTopup("1799","Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 24GB data, 3600 National SMS for 365 days","1 year"));
                userList.add(new ModalTopup("2999","Enjoy Truly unlimited Local, STD & Roaming calls on any network within India, daily 2GB data & 100 SMS, ","1 year"));
                userList.add(new ModalTopup("3359","Enjoy unlimited Local, STD & Roaming calls on any network, daily 2.5GB & 100 SMS | Pack Valid for 365 days","1 year"));
            }else if(sname.equals("Bihar")||sname.equals("Himachal Pradesh")||sname.equals("Hariyana")||sname.equals("Jammu Kashmir")){
                userList.add(new ModalTopup("","",""));
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_local, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();

        recycler = getView().findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
        localAdapter = new LocalAdapter(userList,getContext());
        recycler.setAdapter(localAdapter);
        localAdapter.notifyDataSetChanged();


    }
}