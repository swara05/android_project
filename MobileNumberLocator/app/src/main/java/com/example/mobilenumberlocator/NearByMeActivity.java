package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class NearByMeActivity extends AppCompatActivity {

    ImageView back;

    LinearLayout layoutAmusementPark;
    LinearLayout layoutApparel;
    LinearLayout layoutArt;
    LinearLayout layoutAtm;
    LinearLayout layoutBank;
    LinearLayout layoutBar;
    LinearLayout layoutBeauty;
    LinearLayout layoutBeautySalon;
    LinearLayout layoutCarDealer;
    LinearLayout layoutCoffee;
    LinearLayout layoutConvenienceStore;
    LinearLayout layoutDelivery;
    LinearLayout layoutDryClean;
    LinearLayout layoutElectronics;
    LinearLayout layoutGas;
    LinearLayout layoutGroceries;
    LinearLayout layoutGym;
    LinearLayout layoutHomeGarden;
    LinearLayout layoutHospital;
    LinearLayout layoutHotel;
    LinearLayout layoutJelwery;
    LinearLayout layoutLibrary;
    LinearLayout layoutMovie;
    LinearLayout layoutMuseum;
    LinearLayout layoutNightlife;
    LinearLayout layoutPark;
    LinearLayout layoutParking;
    LinearLayout layoutPharmacy;
    LinearLayout layoutRestaurant;
    LinearLayout layoutShoppingCenter;
    LinearLayout layoutStadium;
    String[] placenames = {"delivery", "bus station", "train station", "airport", "restaurant", "bank", "atm", "hospital", "police", "lodging", "car repair", "gas station", "mosque", "hindu temple", "church", "jewelry store", "shopping mall", "bar", "spa", "beauty salon", "amusement park", "aquarium", "park", "zoo", "cafe", "dry cleaning", "pharmacy", "bakery", "doctor", "veterinary care", "dentist", "gym", "book store", "bowling alley", "car rental", "car wash", "taxi stand", "parking", "art gallery", "electronics store", "casino", "convenience store", "school", "fire station", "lawyer", "department store", "library", "liquor store", "movie theater", "museum", "night club", "pet store", "stadium", "local government office", "groceries", "car dealers", "home garden store", "clothing stores"};
    int position;
    private int a;
    private  boolean key = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_me);
        getWindow().setFlags(1024, 1024);


        this.layoutRestaurant = (LinearLayout) findViewById(R.id.layoutRestaurant);
        this.layoutBar = (LinearLayout) findViewById(R.id.layoutBar);
        this.layoutCoffee = (LinearLayout) findViewById(R.id.layoutCoffee);
        this.layoutDelivery = (LinearLayout) findViewById(R.id.layoutDelivery);
        this.layoutPark = (LinearLayout) findViewById(R.id.layoutPark);
        this.layoutGym = (LinearLayout) findViewById(R.id.layoutGym);
        this.layoutArt = (LinearLayout) findViewById(R.id.layoutArt);
        this.layoutStadium = (LinearLayout) findViewById(R.id.layoutStadium);
        this.layoutNightlife = (LinearLayout) findViewById(R.id.layoutNightlife);
        this.layoutAmusementPark = (LinearLayout) findViewById(R.id.layoutAmusementPark);
        this.layoutMovie = (LinearLayout) findViewById(R.id.layoutMovie);
        this.layoutMuseum = (LinearLayout) findViewById(R.id.layoutMuseum);
        this.layoutLibrary = (LinearLayout) findViewById(R.id.layoutLibrary);
        this.layoutGroceries = (LinearLayout) findViewById(R.id.layoutGroceries);
        this.layoutBeauty = (LinearLayout) findViewById(R.id.layoutBook);
        this.layoutCarDealer = (LinearLayout) findViewById(R.id.layoutCarDealer);
        this.layoutHomeGarden = (LinearLayout) findViewById(R.id.layoutHomeGarden);
        this.layoutApparel = (LinearLayout) findViewById(R.id.layoutClothing);
        this.layoutShoppingCenter = (LinearLayout) findViewById(R.id.layoutShoppingCenter);
        this.layoutElectronics = (LinearLayout) findViewById(R.id.layoutElectronics);
        this.layoutJelwery = (LinearLayout) findViewById(R.id.layoutJelwery);
        this.layoutConvenienceStore = (LinearLayout) findViewById(R.id.layoutConvenienceStore);
        this.layoutHotel = (LinearLayout) findViewById(R.id.layoutHotel);
        this.layoutAtm = (LinearLayout) findViewById(R.id.layoutAtm);
        this.layoutBeautySalon = (LinearLayout) findViewById(R.id.layoutBeautySalon);
        this.layoutPharmacy = (LinearLayout) findViewById(R.id.layoutPharmacy);
        this.layoutBank = (LinearLayout) findViewById(R.id.layoutBank);
        this.layoutDryClean = (LinearLayout) findViewById(R.id.layoutDryClean);
        this.layoutGas = (LinearLayout) findViewById(R.id.layoutGas);
        this.layoutHospital = (LinearLayout) findViewById(R.id.layoutHospital);
        this.layoutParking = (LinearLayout) findViewById(R.id.layoutParking);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void restaurant(View view) {
        doAction(4);
    }

    public void bar(View view) {
        doAction(17);
    }

    public void cafe(View view) {
        doAction(24);
    }

    public void delivery(View view) {
        doAction(0);
    }

    public void lodging(View view) {
        doAction(9);
    }

    public void atm(View view) {
        doAction(6);
    }

    public void saloon(View view) {
        doAction(19);
    }

    public void bank(View view) {
        doAction(5);
    }

    public void drycleaning(View view) {
        doAction(25);
    }

    public void hospitals(View view) {
        doAction(7);
    }

    public void gas(View view) {
        doAction(11);
    }

    public void pharmacy(View view) {
        doAction(26);
    }

    public void parking(View view) {
        doAction(37);
    }

    public void park(View view) {
        doAction(22);
    }

    public void gym(View view) {
        doAction(31);
    }

    public void art(View view) {
        doAction(38);
    }

    public void stadium(View view) {
        doAction(52);
    }

    public void nightlife(View view) {
        doAction(50);
    }

    public void amusement(View view) {
        doAction(20);
    }

    public void movies(View view) {
        doAction(48);
    }

    public void musium(View view) {
        doAction(49);
    }

    public void library(View view) {
        doAction(46);
    }

    public void groceries(View view) {
        doAction(54);
    }

    public void book(View view) {
        doAction(32);
    }

    public void cardealer(View view) {
        doAction(55);
    }

    public void homegarden(View view) {
        doAction(56);
    }

    public void clothing(View view) {
        doAction(57);
    }

    public void shopping(View view) {
        doAction(16);
    }

    public void electronics(View view) {
        doAction(39);
    }

    public void jewellery(View view) {
        doAction(15);
    }

    public void convenience(View view) {
        doAction(41);
    }

    private void doAction(final int i) {
        if (a == 0 ){

            NearByMeActivity.this.position = i;
            NearByMeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.co.in/maps?q=" + NearByMeActivity.this.placenames[i])));
            a++;
        }
        else if(a == 1){
            NearByMeActivity.this.position = i;
            NearByMeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.co.in/maps?q=" + NearByMeActivity.this.placenames[i])));
            a = 2;
        }
        else if(a == 2){
            NearByMeActivity.this.position = i;
            NearByMeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.co.in/maps?q=" + NearByMeActivity.this.placenames[i])));
            a = 3;
        }
        else if(a == 3){
            NearByMeActivity.this.position = i;
            NearByMeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.co.in/maps?q=" + NearByMeActivity.this.placenames[i])));
            a = 4;
        }
        else if(a == 4){
            NearByMeActivity.this.position = i;
            NearByMeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.co.in/maps?q=" + NearByMeActivity.this.placenames[i])));
            a = 0;
        }
    }

}