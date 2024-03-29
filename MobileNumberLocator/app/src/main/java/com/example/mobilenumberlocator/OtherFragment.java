package com.example.mobilenumberlocator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class OtherFragment extends Fragment {

    RecyclerView recycler;
    OtherAdapter otherAdapter;
    List<ModalTopup> userList;
    LinearLayoutManager linearLayoutManager;

    private void initData() {
        userList = new ArrayList<>();
        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("value1");
        String sname = intent.getStringExtra("value2");

        if(name.equals("Airtel")) {
            if (sname.equals("Assam") || sname.equals("Chennai") || sname.equals("Delhi NCR") || sname.equals("Gujarat") || sname.equals("Himachal Pradesh") || sname.equals("Jammu Kashmir")) {


//        userList.add(new ModalTopup("19","Data: 1GB | Validity: 1 Day","1 day"));
//        userList.add(new ModalTopup("29","Data: 2GB | Validity: 1 Day(till midnight)Only for customers with active validity","1 day"));
//        userList.add(new ModalTopup("58","3 GB Data | Validity same as your existing bundle/smart pack","N/A"));
//        userList.add(new ModalTopup("65","4 GB Data | Validity same as your existing bundle/smart pack","N/A"));
                userList.add(new ModalTopup("98", "Data: 5 GB Wynk Music Premium subscription | Validity: Same as your existing pack ❘ Pack Applicable for active validity", "N/A"));
                //  userList.add(new ModalTopup("118","12 GB Data | Validity same as your existing bundle /smart pack","N/A"));
                userList.add(new ModalTopup("148", "Xstream Mobile Data Pack: 15GB Data | Additional Benefits: Xstream App (Watch Shark Tank 2)28 days", "N/A"));
                userList.add(new ModalTopup("149", "1 GB data, validity as per current pack,Xstream Premium for 1 Month: Get 15+ OTTS in 1 App : SonyLiv, Eros", "N/A"));
                userList.add(new ModalTopup("155", "Enjoy Unlimited Local, STD & Roaming calls Local STD & Roaming calls on any network 1GB data & 300", "24 days"));
                userList.add(new ModalTopup("179", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data, 300 National SMS for 28 days", "28 days"));
                //  userList.add(new ModalTopup("181","Data: 1GB/day; Validity: 30 DAYS 30 days","30 days"));
                userList.add(new ModalTopup("199", "Enjoy unlimited Local, STD & Roaming calls on any network, Total 3GB Data, Rs.5 Talktime & 300 SMS | Valid for 30", "30 days"));
                userList.add(new ModalTopup("209", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, daily 1GB data and 100 SMS ", "21 days"));
                userList.add(new ModalTopup("239", "Enjoy unlimited Local, STD & Roaming calls on any network, 1GB/day data and 100 SMS | Pack valid for 24 days", "24 days"));
                userList.add(new ModalTopup("265", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1 GB data per day, 100 National SMS/day", "28 days"));
                userList.add(new ModalTopup("296", "Enjoy unlimited Local, STD & Roaming calls on any network, 25GB Data and 100 SMS/day|Claim UNLIMITED", "30 days"));
                userList.add(new ModalTopup("299", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/ ", "28 days"));
                userList.add(new ModalTopup("301", "Enjoy 50 GB and 1year of Wynk Music Premium subscription | Validity same as your existing bundle /smart pack", "N/A"));
                userList.add(new ModalTopup("319", "Enjoy unlimited Local, STD & Roaming calls on any network, 2GB/day Data and 100 SMS/day,Validity: 1 Month", "1 month"));
                userList.add(new ModalTopup("359", "Enjoy unlimited Local, STD & Roaming calls on any network, daily 2GB data, Rs.5 Talktime and 100 SMS | Pack", "1 month"));
                userList.add(new ModalTopup("399", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2.5GB data per day, 100 National SMS/day", "28 days"));
                userList.add(new ModalTopup("455", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 6GB data, 900 National SMS for 84", "84 days"));
                userList.add(new ModalTopup("479", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/day", "56 days"));
                userList.add(new ModalTopup("489", "Enjoy unlimited Local, STD & Roaming calls on any network, Total 50GB Data & 300 SMS|Apollo 24|7 Circle", "30 days"));
                userList.add(new ModalTopup("499", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 3 GB data per day, 100 National SMS/day", "28 days"));
                userList.add(new ModalTopup("509", "Enjoy unlimited Local, STD & Roaming calls on any network, Total 60GB Data & 300 SMS Valid for 1 month", "1 month"));
                userList.add(new ModalTopup("519", "Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Apollo 24|7 Circle", "60 days"));
                userList.add(new ModalTopup("549", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data per day, 100 National SMS/day", "56 days"));
                userList.add(new ModalTopup("666", "Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Apollo 24|7 Circle", "77 days"));
                userList.add(new ModalTopup("699", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 3 GB data per day, 100 National SMS", "56 days"));
                userList.add(new ModalTopup("719", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 1.5 GB data per day, 100 National SMS/day", "84 days"));
                userList.add(new ModalTopup("779", "Enjoy Truly unlimited Local, STD & Roaming calls on any network, daily 1.5GB & 100 SMS|Claim UNLIMITED", "90 days"));
                userList.add(new ModalTopup("839", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 2 GB data per day, 100 National SMS/day", "84 days"));
                userList.add(new ModalTopup("999", "Enjoy unlimited Local, STD & Roaming calls on any network, 2.5GB/day data and 100 SMS/day and Claim ", "84 days"));
                userList.add(new ModalTopup("1799", "Enjoy TRULY unlimited Local, STD & Roaming calls on any network, 24GB data, 3600 National SMS for 365 days", "1 year"));
                userList.add(new ModalTopup("2999", "Enjoy Truly unlimited Local, STD & Roaming calls on any network within India, daily 2GB data & 100 SMS, ", "1 year"));
                userList.add(new ModalTopup("3359", "Enjoy unlimited Local, STD & Roaming calls on any network, daily 2.5GB & 100 SMS | Pack Valid for 365 days", "1 year"));
            }else if(sname.equals("Bihar") || sname.equals("Hariyana")){
                userList.add(new ModalTopup("","",""));
            }
        }else if(name.equals("Jio"))
        {
            if(sname.equals("Assam") ||sname.equals("Chennai") || sname.equals("Delhi NCR") || sname.equals("Gujarat") || sname.equals("Himachal Pradesh") || sname.equals("Jammu Kashmir")){
                userList.add(new ModalTopup("75","For JioPhone Customers only Data: 2.5GB (0.1GB/day + 200MB) Voice: Unlimited Calls SMS: 50 Validity: 23","23 days"));
                userList.add(new ModalTopup("91","For JioPhone Customers only Data: 3GB (0.1GB/day + 200MB) Voice: Unlimited Calls SMS: 50 Validity: 28 ","28 days"));
                userList.add(new ModalTopup("119","Data: 1.5 GB/day Voice: Unlimited Calls SMS: 300 Validity : 14 Days Complimentary subscription to Jio ","14 days"));
                userList.add(new ModalTopup("125","For JioPhone Customers only Data: 0.5GB/day Voice: Unlimited Calls SMS: 300 Validity :23 days","23 days"));
                userList.add(new ModalTopup("149","Data: 1 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 20 Days Complimentary subscription to Jio ","20 days"));
                userList.add(new ModalTopup("152","For JioPhone Customers only Data: 0.5GB/day Voice: Unlimited Calls SMS: 300 Validity: 28 Days ","28 days"));
                userList.add(new ModalTopup("179","Data: 1 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 24 Days Complimentary subscription to Jio ","24 days"));
                userList.add(new ModalTopup("186","For JioPhone Customers only Data: 1 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 28 Days ","28 days"));
                userList.add(new ModalTopup("199","Data: 1.5 GB/day, Voice: Unlimited Calls, SMS: 100 SMS/day Validity: 23 Days Complimentary subscriptions"," 23 day"));
                userList.add(new ModalTopup("209","Data: 1 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 28 Days Complimentary subscription to Jio ","28 days"));
                userList.add(new ModalTopup("219","Data: 3 GB/day + 2 GB Voice: Unlimited Calls SMS: 100 SMS/day Validity: 14 Days Complimentary ","14 days"));
                userList.add(new ModalTopup("2223","For JioPhone Customers only: Data: 56 GB (2GB/Day) Voice: Unlimited Calls SMS: 100 SMS/day Validity: 28 ","28 days"));
                userList.add(new ModalTopup("239","Data: 1.5 GB/day, Voice: Unlimited\n" +
                        "Calls SMS: 100 SMS/day Validity: 28 Days Complimentary subscription ","28 days"));
                userList.add(new ModalTopup("249","Data: 2 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 23 Days Complimentary subscription to Jio ","23 days"));
                userList.add(new ModalTopup("259","Data: 1.5 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 1 Month Complimentary subscription ","1 Month"));
                userList.add(new ModalTopup("296","Data: 25 GB Voice: Unlimited Calls SMS: 100 SMS/day Validity: 30 Days Complimentary subscription to Jio ","30 days"));
                userList.add(new ModalTopup("299","Data: 2 GB/day, Voice: Unlimited Calls SMS: 100 SMS/day Validity: 28 Days Complimentary subscription to Jio ","28 days"));
                userList.add(new ModalTopup("349","Data: 2.5 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 30 Days Complimentary subscription to ","30 days"));
                userList.add(new ModalTopup("399","Data: 3 GB/day + 6 GB Voice: Unlimited Calls SMS: 100 SMS/day Validity: 28 Days Complimentary ","28 days"));
                userList.add(new ModalTopup("479","Data: 1.5 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 56 Days Complimentary subscription ","56 days"));
                userList.add(new ModalTopup("533","Data: 2 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 56 Days Complimentary subscription to Jio ","56 days"));
                userList.add(new ModalTopup("666","Data: 1.5 GB/day, Voice: Unlimited Calls SMS: 100 SMS/day Validity: 84 Days Complimentary subscription to ","84 days"));
                userList.add(new ModalTopup("719","Data: 2 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 84 Days Complimentary subscription to Jio ","84 days"));
                userList.add(new ModalTopup("749","Data: 2 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 90 Days Complimentary subscription to Jio ","90 days"));
                userList.add(new ModalTopup("895","For JioPhone Customers only: Data: 2 GB/28 days (12 cycles) Voice: Unlimited Calls SMS: 50 SMS for 28 ","336 days"));
                userList.add(new ModalTopup("899","Data:2.5 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 90 Days Complimentary subscription ","90 days"));
                userList.add(new ModalTopup("999","Data: 3 GB/day + 40 GB Voice: Unlimited Calls SMS: 100 SMS/day Validity: 84 Days Complimentary ","84 days"));
                userList.add(new ModalTopup("2023","New Year Special Plan Data: 2.5GB/ Day (630 GB) Voice: Unlimited Calls SMS: 100 SMS/Day Validity ","252 days"));
                userList.add(new ModalTopup("2545","Data: 1.5 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 336 Days Complimentary subscription ","336 days"));
                userList.add(new ModalTopup("2879","Data: 2 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 365 Days Complimentary subscription to Jio","1 year"));
                userList.add(new ModalTopup("2999","Jio New Year Special offer Data: 2.5GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 365 Days ","1 year"));
                userList.add(new ModalTopup("75","For JioPhone Customers only Data: 2.5GB (0.1GB/day + 200MB) Voice: Unlimited Calls SMS: 50 Validity: 23 ","23 days"));
                userList.add(new ModalTopup("91","For JioPhone Customers only Data: 3GB (0.1GB/day + 200MB) Voice: Unlimited Calls SMS: 50 Validity: 28 ","28 days"));
                userList.add(new ModalTopup("119","Data: 1.5 GB/day Voice: Unlimited Calls SMS: 300 Validity : 14 Days Complimentary subscription to Jio ","14 days"));
                userList.add(new ModalTopup("125","For JioPhone Customers only Data: 0.5GB/day Voice: Unlimited Calls SMS: 300 Validity :23 days","23 days"));
                userList.add(new ModalTopup("149","Data: 1 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 20 Days Complimentary subscription to Jio ","20 days"));
                userList.add(new ModalTopup("152","For JioPhone Customers only Data: 0.5GB/day Voice: Unlimited Calls SMS: 300 Validity: 28 Days ","28 days"));
                userList.add(new ModalTopup("179","Data: 1 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 24 Days Complimentary subscription to Jio ","24 days"));
                userList.add(new ModalTopup("186","For JioPhone Customers only Data: 1 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 28 Days ","28 days"));
                userList.add(new ModalTopup("199","Data: 1.5 GB/day, Voice: Unlimited Calls, SMS: 100 SMS/day Validity: 23 Days Complimentary subscriptions"," 23 day"));
                userList.add(new ModalTopup("209","Data: 1 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 28 Days Complimentary subscription to Jio ","28 days"));
                userList.add(new ModalTopup("219","Data: 3 GB/day + 2 GB Voice: Unlimited Calls SMS: 100 SMS/day Validity: 14 Days Complimentary ","14 days"));
                userList.add(new ModalTopup("2223","For JioPhone Customers only: Data: 56 GB (2GB/Day) Voice: Unlimited Calls SMS: 100 SMS/day Validity: 28 ","28 days"));
                userList.add(new ModalTopup("239","Data: 1.5 GB/day, Voice: Unlimited\n" +
                        "Calls SMS: 100 SMS/day Validity: 28 Days Complimentary subscription ","28 days"));
                userList.add(new ModalTopup("249","Data: 2 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 23 Days Complimentary subscription to Jio ","23 days"));
                userList.add(new ModalTopup("259","Data: 1.5 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 1 Month Complimentary subscription ","1 Month"));
                userList.add(new ModalTopup("296","Data: 25 GB Voice: Unlimited Calls SMS: 100 SMS/day Validity: 30 Days Complimentary subscription to Jio ","30 days"));
                userList.add(new ModalTopup("299","Data: 2 GB/day, Voice: Unlimited Calls SMS: 100 SMS/day Validity: 28 Days Complimentary subscription to Jio ","28 days"));
                userList.add(new ModalTopup("349","Data: 2.5 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 30 Days Complimentary subscription to ","30 days"));
                userList.add(new ModalTopup("399","Data: 3 GB/day + 6 GB Voice: Unlimited Calls SMS: 100 SMS/day Validity: 28 Days Complimentary ","28 days"));
                userList.add(new ModalTopup("479","Data: 1.5 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 56 Days Complimentary subscription ","56 days"));
                userList.add(new ModalTopup("533","Data: 2 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 56 Days Complimentary subscription to Jio ","56 days"));
                userList.add(new ModalTopup("666","Data: 1.5 GB/day, Voice: Unlimited Calls SMS: 100 SMS/day Validity: 84 Days Complimentary subscription to ","84 days"));
                userList.add(new ModalTopup("719","Data: 2 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 84 Days Complimentary subscription to Jio ","84 days"));
                userList.add(new ModalTopup("749","Data: 2 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 90 Days Complimentary subscription to Jio ","90 days"));
                userList.add(new ModalTopup("895","For JioPhone Customers only: Data: 2 GB/28 days (12 cycles) Voice: Unlimited Calls SMS: 50 SMS for 28 ","336 days"));
                userList.add(new ModalTopup("899","Data:2.5 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 90 Days Complimentary subscription ","90 days"));
                userList.add(new ModalTopup("999","Data: 3 GB/day + 40 GB Voice: Unlimited Calls SMS: 100 SMS/day Validity: 84 Days Complimentary ","84 days"));
                userList.add(new ModalTopup("2023","New Year Special Plan Data: 2.5GB/ Day (630 GB) Voice: Unlimited Calls SMS: 100 SMS/Day Validity ","252 days"));
                userList.add(new ModalTopup("2545","Data: 1.5 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 336 Days Complimentary subscription ","336 days"));
                userList.add(new ModalTopup("2879","Data: 2 GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 365 Days Complimentary subscription to Jio","1 year"));
                userList.add(new ModalTopup("2999","Jio New Year Special offer Data: 2.5GB/day Voice: Unlimited Calls SMS: 100 SMS/day Validity: 365 Days ","1 year"));

            }else if(sname.equals("Bihar") || sname.equals("Hariyana")){
                userList.add(new ModalTopup("","",""));
            }
        }else if(name.equals("Vodafone")){
            if (sname.equals("Assam") || sname.equals("Himachal Pradesh") || sname.equals("Jammu Kashmir")) {

                userList.add(new ModalTopup("47", "Callertunes with unlimited song change at rs | 47 for 28 days", "28 days"));
                userList.add(new ModalTopup("78", "Callertunes with unlimited song change at rs | 78 for 89 days", "89 days"));
            }else if(sname.equals("Bihar") || sname.equals("Hariyana")){
                userList.add(new ModalTopup("","",""));
            }else if(sname.equals("Chennai") || sname.equals("Delhi NCR")|| sname.equals("Gujarat")  ){
                userList.add(new ModalTopup("47", "Callertunes with unlimited song change at rs | 47 for 28 days", "28 days"));
                userList.add(new ModalTopup("78", "Callertunes with unlimited song change at rs | 78 for 89 days", "89 days"));
                userList.add(new ModalTopup("295", "international roaming calls which include outgoing local calls, calls", "28 days"));
                userList.add(new ModalTopup("695", "This pack is available in 23 countries including the us, uae, singapore, thailand, malaysia, uk, new zealand & 1 day", "89 days"));
                userList.add(new ModalTopup("995", "Intl Roaming | Get free 150 min outgoing & incoming calls & 500 mb when roaming abroad in us, 7 days", "28 days"));
                userList.add(new ModalTopup("1495", "Intl Roaming | Get free 300 min outgoing & incoming calls & 1gb when roaming abroad in us, uk, singapore, 14 days", "89 days"));
                userList.add(new ModalTopup("2695", "This pack is available in 23 countries including the us, uae, singapore, thailand, malaysia, uk, new zealand & 4 days", "28 days"));
                userList.add(new ModalTopup("3495", "This pack is available in 23 countries including the us, uae, singapore, thailand, malaysia, uk, new zealand & 7 days", "89 days"));
                userList.add(new ModalTopup("4695", "This pack is available in 23 countries including the us, uae, singapore, thailand, malaysia, uk, new zealand & 10 days", "28 days"));
                userList.add(new ModalTopup("6995", "This pack is available in 23 countries including the us, uae, singapore, thailand, malaysia, uk, new zealand & 28 days", "89 days"));
            }
        }else if(name.equals("Idea")) {
            if (sname.equals("Assam") || sname.equals("Himachal Pradesh") || sname.equals("Jammu Kashmir")) {

                userList.add(new ModalTopup("47", "Callertunes with unlimited song change at rs | 47 for 28 days", "28 days"));
                userList.add(new ModalTopup("78", "Callertunes with unlimited song change at rs | 78 for 89 days", "89 days"));
            } else if (sname.equals("Bihar") || sname.equals("Hariyana")) {
                userList.add(new ModalTopup("", "", ""));
            } else if (sname.equals("Chennai") || sname.equals("Delhi NCR") || sname.equals("Gujarat")) {
                userList.add(new ModalTopup("47", "Callertunes with unlimited song change at rs | 47 for 28 days", "28 days"));
                userList.add(new ModalTopup("78", "Callertunes with unlimited song change at rs | 78 for 89 days", "89 days"));
                userList.add(new ModalTopup("295", "international roaming calls which include outgoing local calls, calls", "28 days"));
                userList.add(new ModalTopup("695", "This pack is available in 23 countries including the us, uae, singapore, thailand, malaysia, uk, new zealand & 1 day", "89 days"));
                userList.add(new ModalTopup("995", "Intl Roaming | Get free 150 min outgoing & incoming calls & 500 mb when roaming abroad in us, 7 days", "28 days"));
                userList.add(new ModalTopup("1495", "Intl Roaming | Get free 300 min outgoing & incoming calls & 1gb when roaming abroad in us, uk, singapore, 14 days", "89 days"));
                userList.add(new ModalTopup("2695", "This pack is available in 23 countries including the us, uae, singapore, thailand, malaysia, uk, new zealand & 4 days", "28 days"));
                userList.add(new ModalTopup("3495", "This pack is available in 23 countries including the us, uae, singapore, thailand, malaysia, uk, new zealand & 7 days", "89 days"));
                userList.add(new ModalTopup("4695", "This pack is available in 23 countries including the us, uae, singapore, thailand, malaysia, uk, new zealand & 10 days", "28 days"));
                userList.add(new ModalTopup("6995", "This pack is available in 23 countries including the us, uae, singapore, thailand, malaysia, uk, new zealand & 28 days", "89 days"));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();

        recycler = getView().findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
        otherAdapter = new OtherAdapter(userList,getContext());
        recycler.setAdapter(otherAdapter);
        otherAdapter.notifyDataSetChanged();


    }
}